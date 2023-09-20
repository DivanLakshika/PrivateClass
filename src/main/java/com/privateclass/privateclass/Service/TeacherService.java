package com.privateclass.privateclass.Service;

import com.privateclass.privateclass.Entity.Student;
import com.privateclass.privateclass.LoginDto.LoginDto;
import com.privateclass.privateclass.Repo.StudentRepo;
import com.privateclass.privateclass.Repo.TeacherRepo;
import com.privateclass.privateclass.Entity.Teacher;
import com.privateclass.privateclass.ValidationAll.SaveTeacherV;
import com.privateclass.privateclass.ValidationAll.TeacherValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherService  {

    @Autowired
    TeacherRepo teacherRepo;
    @Autowired
    TeacherValidation teacherValidation;
    @Autowired
    SaveTeacherV saveTeacherV;
    @Autowired
    StudentRepo studentRepo;


    public ResponseEntity<String> saveTeacherVa(Teacher teacher){

        return saveTeacherV.saveTeacherValid(teacher);
    }


    public ResponseEntity <List<Teacher>> allTeachers() {
            try{

                return new ResponseEntity<>(teacherRepo.findAll(),HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }



    public ResponseEntity<String> loginTeacherV(LoginDto loginDto) {

        return teacherValidation.loginValidation(loginDto);

    }


/*    public ResponseEntity<Teacher> assignStudentToTeacher(Long teacherId, Long studentId) {
        try {
            Optional<Student> studentOptional=studentRepo.findById(studentId);
            Optional<Teacher> teacherOptional=teacherRepo.findById(teacherId);
            if (!teacherOptional.isPresent() || !studentOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                Teacher teacher=teacherOptional.get();
                Student student=studentOptional.get();

                teacher.getAssignStudents().add(student);
                teacherRepo.save(teacher);
                return new ResponseEntity<>(teacherRepo.save(teacher),HttpStatus.OK);
          /*  Set<Student> studentSet=null;
            Teacher teacher=teacherRepo.findById(teacherId).get();
            Student student=studentRepo.findById(studentId).get();
            studentSet = teacher.getAssignStudents(); //Now student set that are in this id
            studentSet.add(student); // adding new student for the id
            teacher.setAssignStudents(studentSet);
            return new ResponseEntity<>(teacherRepo.save(teacher),HttpStatus.OK) ;

        }
       catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    public ResponseEntity<Teacher> saveTeacherWithStudent(Teacher teacher) {
        return new ResponseEntity<>(teacherRepo.save(teacher),HttpStatus.OK) ;
    }
*/

    //9/19
    public ResponseEntity<Student> addStudentByTeacherId(Long teacherId, Student student) {
             Optional<Teacher> teacher1 = teacherRepo.findById(teacherId);

             if(teacher1.isPresent()){
                 student.setTeacher(teacher1.get());
                 studentRepo.save(student);

                 return new ResponseEntity<>(HttpStatus.OK);
             }
             else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Student>> getAllStudentsForTeacher(Long teacherId) {

        Optional<Teacher> teacher2= teacherRepo.findById(teacherId);
        if(teacher2.isPresent()){
            List<Student> stdList =  studentRepo.findByTeacherId(teacherId);
            return new ResponseEntity<>(stdList,HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    public ResponseEntity<?> updateTeacher(Long teacherId, Teacher updatedTeacher) {

            Optional<Teacher> teacher=teacherRepo.findById(teacherId);

            if(teacher.isPresent()){

                Teacher existingTeacher= teacher.get();

                existingTeacher.setName(updatedTeacher.getName());
                existingTeacher.setEmail(updatedTeacher.getEmail());
                existingTeacher.setStream(updatedTeacher.getStream());
                existingTeacher.setSubject(updatedTeacher.getSubject());
                existingTeacher.setPassword(updatedTeacher.getPassword());
                existingTeacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
                    teacherRepo.save(existingTeacher);

                return new ResponseEntity<>(HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<?> deleteTeacher(Long teacherId) {

        Optional<Teacher> teacher=teacherRepo.findById(teacherId);
        if(teacher.isPresent()) {
            teacherRepo.delete(teacher.get());
          return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

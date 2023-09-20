package com.privateclass.privateclass.Service;

import com.privateclass.privateclass.Entity.Student;
import com.privateclass.privateclass.Entity.Teacher;
import com.privateclass.privateclass.Repo.StudentRepo;
import com.privateclass.privateclass.Repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    TeacherRepo teacherRepo;

    public ResponseEntity<String> addS(Student student) {
        try{ if (!student.getName().equals("") ){
            studentRepo.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        }catch(Exception E){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    public ResponseEntity<List<Student>> allStudent() {

       try{
        return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
       }catch (Exception e){return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
    }

  

    public ResponseEntity<Student> updateStudent(Long studentId, Student updatedStudent) {
        
                Optional<Student> student=studentRepo.findById(studentId);
                
                if(student.isPresent()){
                    Student existingStudent=student.get();
                    
                    existingStudent.setName(updatedStudent.getName());
                    existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
                    existingStudent.setAddress(updatedStudent.getAddress());
                    existingStudent.setClz(updatedStudent.getClz());
                    
                    return new ResponseEntity<>(studentRepo.save(existingStudent),HttpStatus.OK);
                }
                else 
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    public ResponseEntity<?> deleteStudent(Long studentId) {

        Optional<Student> student= studentRepo.findById(studentId);
        if(student.isPresent()){

            studentRepo.delete(student.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    /*
    public ResponseEntity<List<Student>>  findStudentsByTeacherId(Long teacherId) {
           Optional<Teacher> teacher= teacherRepo.findById(teacherId);
           if(teacher.isPresent()){
               Set<Student> students= teacher.get().getAssignStudents(); //Only one at a time data come no,then need list that is why student list
               return new ResponseEntity<>(new ArrayList<>(students),HttpStatus.OK); // students comes from just like list but not list that is why creating list
           }
           else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //    return new ResponseEntity<>(teacherRepo.findById(teacherId),HttpStatus.OK )
         //   return  studentRepo.findStudentsByTeacherIdRepo(teacherId);
    }*/
}

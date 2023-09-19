package com.privateclass.privateclass.Controller;


import com.privateclass.privateclass.Entity.Student;
import com.privateclass.privateclass.LoginDto.LoginDto;
import com.privateclass.privateclass.Service.TeacherService;
import com.privateclass.privateclass.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/getAll")
    public ResponseEntity < List<Teacher>>  getAllTeachers(){

        return teacherService.allTeachers();
    }


    @PostMapping("/add")
    public ResponseEntity<String> TeacherAddingV(@RequestBody Teacher teacher){
          return teacherService.saveTeacherVa(teacher);
    }

    // need to pass id for react js
    @PostMapping("/login")
    public ResponseEntity<String> TeacherLoginV(@RequestBody LoginDto loginDto ){
        return teacherService.loginTeacherV(loginDto);
    }

/*   @PutMapping("/{teacherId}/student/{studentId}")
    public ResponseEntity<Teacher>  assignStudents(
            @PathVariable Long teacherId, @PathVariable Long studentId
    ){
       return teacherService.assignStudentToTeacher(teacherId,studentId);
    } */


/*    @PostMapping("/aaa")
    public ResponseEntity<Teacher> saveTeacherWithStudent(@RequestBody Teacher teacher){
            return teacherService.saveTeacherWithStudent(teacher);
    } */


// 9/19 updated in below
    @PostMapping("/{teacherId}/student")
    public  ResponseEntity<Student> addStudentByTeacher(@PathVariable Long teacherId,@RequestBody Student student){

            return teacherService.addStudentByTeacherId(teacherId,student);

    }

    @GetMapping("{teacherId}/students")
    public ResponseEntity<List<Student>> showStudentsByTeacherId(@PathVariable Long teacherId){

            return teacherService.getAllStudentsForTeacher(teacherId);

    }

}


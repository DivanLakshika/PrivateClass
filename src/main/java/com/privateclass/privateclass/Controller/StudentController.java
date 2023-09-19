package com.privateclass.privateclass.Controller;


import com.privateclass.privateclass.Entity.Student;
import com.privateclass.privateclass.Entity.Teacher;
import com.privateclass.privateclass.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// we don't need this
@RestController

@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<String>  studentAdd(@RequestBody Student student){

        return studentService.addS(student);
    }
    @PostMapping("/addd")
    public Student Stdadd(@RequestBody Student student){
        return studentService.adding(student);
    }
    @GetMapping("/allStudent")
    public ResponseEntity<List<Student>>  listOfStudent(){

        return studentService.allStudent();
    }


}

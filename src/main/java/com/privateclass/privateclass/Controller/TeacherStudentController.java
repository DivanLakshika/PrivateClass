package com.privateclass.privateclass.Controller;

import com.privateclass.privateclass.Entity.Student;
import com.privateclass.privateclass.Entity.Teacher;
import com.privateclass.privateclass.Repo.StudentRepo;
import com.privateclass.privateclass.Repo.TeacherRepo;
import com.privateclass.privateclass.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// we don't need this
@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherStudentController {

    @Autowired
    StudentService studentService;
    /*
    @GetMapping("/{teacherId}/students")
    public ResponseEntity<List<Student>>  getStudentByTeacherId(@PathVariable Long teacherId){

        return studentService.findStudentsByTeacherId(teacherId) ;

    }*/

}

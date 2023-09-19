package com.privateclass.privateclass.ValidationAll;

import com.privateclass.privateclass.Repo.TeacherRepo;
import com.privateclass.privateclass.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaveTeacherV  {
    @Autowired
    TeacherRepo teacherRepo;
    public ResponseEntity<String> saveTeacherValid(Teacher teacher) {
        String name= teacher.getName();
        String email= teacher.getEmail();
        String password=teacher.getPassword();
        String phoneNumber= teacher.getPhoneNumber();
        String subject=teacher.getSubject();
        String stream=teacher.getStream();


        try{
        if (!name.equals("") && !email.equals("") && !password.equals("") && !phoneNumber.equals("") && !subject.equals("") && !stream.equals("") ){
            Optional<Teacher> emailSearchTeacher= teacherRepo.findByEmail(email);
            if(!emailSearchTeacher.isPresent()){
                teacherRepo.save(teacher);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{ return new ResponseEntity<>(HttpStatus.IM_USED);

            }
        }
        else {return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

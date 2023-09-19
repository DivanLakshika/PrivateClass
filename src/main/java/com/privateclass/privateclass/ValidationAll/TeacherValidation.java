package com.privateclass.privateclass.ValidationAll;

import com.privateclass.privateclass.LoginDto.LoginDto;
import com.privateclass.privateclass.Repo.TeacherRepo;
import com.privateclass.privateclass.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class TeacherValidation {
    @Autowired
    TeacherRepo teacherRepo;

 /*   public LoginResponse validationLogic(LoginDto loginDto) {
        String msg = "";
       Teacher teacher1 = teacherRepo.findByEmail(loginDto.getEmail());
       Optional <Teacher> teacher2=teacherRepo.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword1());

        if (teacher1 != null) {
            String password = loginDto.getPassword1();
            String encodedPassword = teacher1.getPassword();
            Boolean isPasswordRight = Boolean.valueOf(String.valueOf(password).equals(String.valueOf(encodedPassword)));
            //passwordEncoder.passwordEncoder().matches(password,encodedPassword);

            if (isPasswordRight) {
                Optional<Teacher> teacher = teacherRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword1());
                System.out.println(teacher);
                if (teacher.isPresent()) {
                    return new LoginResponse("login success", true);
                } else {
                    return new LoginResponse("login failed", false);
                }
            } else {
                return new LoginResponse("Password not match", false);


            }
        } else {
            return new LoginResponse("Email not Exist", false);

        }
    } */

    public ResponseEntity<String> loginValidation(LoginDto loginDto) {

        String teacherEmailFromWeb = loginDto.getEmail();
        String teacherPasswordFromWeb = loginDto.getPassword1();
        // id should return to frontend, then frontend can make new https with the id and request from backend to show mapping
        try {
            if (teacherEmailFromWeb != null && teacherPasswordFromWeb != null) {
                Optional<Teacher> teacher = teacherRepo.findByEmailAndPassword(teacherEmailFromWeb,teacherPasswordFromWeb);
                if(teacher.isPresent()){
                  //  String.valueOf(teacher.get().getId()) ,
                    return new ResponseEntity<>(String.valueOf(teacher.get().getId()) ,HttpStatus.OK);  //pass the id value as string to the frontend
                }
                else {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}

            } else { return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
           // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());;
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

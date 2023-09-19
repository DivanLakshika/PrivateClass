package com.privateclass.privateclass.Repo;

import com.privateclass.privateclass.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findByTeacherId(Long teacherId);


    //  List<Student> findStudentsByTeacherIdRepo(Long teacherId);
}


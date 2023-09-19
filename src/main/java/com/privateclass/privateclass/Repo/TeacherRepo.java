package com.privateclass.privateclass.Repo;

import com.privateclass.privateclass.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {


        Optional<Teacher> findByEmailAndPassword(String email, String password);

        Optional <Teacher> findByEmail(String email);

        Teacher findByName(String name);



}



package com.privateclass.privateclass.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String clz;


    @ManyToOne
    @JoinColumn(name= "teacher_id")
    @JsonBackReference //break circular reference
    private Teacher teacher;
    /*
    @ManyToMany(mappedBy = "assignStudents")
    @JsonIgnore
    private Set<Teacher> teacherSet=new HashSet<>();

        */

}

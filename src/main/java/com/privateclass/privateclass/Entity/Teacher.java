package com.privateclass.privateclass.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.source.tree.NewArrayTree;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String stream;
    private String subject;
    private String phoneNumber;
    private String email;
    private String password;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)   //CascadeType.ALL means that if an operation (such as saving or deleting) is applied to the "teacher" entity, the same operation should be cascaded to all associated "child" entities.
    @JsonManagedReference // break circular reference
    private List<Student> students = new ArrayList<>();

    /*

    @ManyToMany
    @JoinTable(name ="teacher_student",
         //   joinColumns = @JoinColumn(name="student_id"),
          //  inverseJoinColumns =@JoinColumn(name ="teacher_id" ) )
            joinColumns = @JoinColumn(name="teacher_id"), //right
            inverseJoinColumns =@JoinColumn(name ="student_id") ) //right
    private Set<Student> assignStudents=new HashSet<>();

*/

}

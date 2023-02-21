package com.example.Student_Library_Management_System.Repository;

import com.example.Student_Library_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmail(String email);

    //select * from student where country=india ;  //return the entities
    List<Student> findByCountry(String country);
}

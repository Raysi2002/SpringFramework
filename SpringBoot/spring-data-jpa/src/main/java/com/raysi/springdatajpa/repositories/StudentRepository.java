package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface StudentRepository extends JpaRepository<Student, Long> {
     List<Student> findStudentByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);

}

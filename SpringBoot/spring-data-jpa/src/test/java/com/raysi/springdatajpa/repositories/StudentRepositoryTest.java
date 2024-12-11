package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Guardian;
import com.raysi.springdatajpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
//        Student student = new Student("Kanxu", "Ydv", "kanxu@gmail.com", "xyz", "xyz@gmail.com", "9899263738");

        Student student = Student.builder()
                        .firstName("Aashish")
                        .lastName("Ray")
                        .emailId("20002raysi@gmail.com")
                        .build();
        studentRepository.save(student);
    }

    @Test
    public void getStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void updateStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .guardianName("Sadajiv")
                .guardianEmail("sParent@yahoo.com")
                .guardianPhone("9810109080")
                .build();
        Student student = Student.builder()
                .firstName("Sonu")
                .lastName("Ahir")
                .emailId("sonu@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findStudentByFirstName(){
        List<Student> studentList = studentRepository.findStudentByFirstName("Aashish");
        System.out.println(studentList);
    }

    @Test
    public void findByNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("kan");
        System.out.println(studentList);
    }
}
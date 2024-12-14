package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.CourseMaterial;
import com.raysi.springdatajpa.entities.Courses;
import com.raysi.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void getTeachers(){

    }

    @Test
    public void saveTeachers(){
//        CourseMaterial courseMaterial = CourseMaterial.builder()
//                .url("raysi.com")
//                .build();
//        Courses course = Courses.builder()
//                .courseTitle("DSA")
//                .credit(100)
//                .build();
//        Teacher teacher = Teacher.builder()
//                .firstName("Preeti")
//                .lastName("Yadav")
////                .courses(List.of(course))
//                .build();
//        teacherRepository.save(teacher);
    }
}
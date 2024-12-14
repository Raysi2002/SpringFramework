package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Courses;
import com.raysi.springdatajpa.entities.CourseMaterial;
import com.raysi.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoursesMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveData(){
        Teacher teacher = Teacher.builder()
                .firstName("Sonu")
                .lastName("Ray")
                .build();
        Courses course = Courses.builder()
                .courseTitle("ADS")
                .teacher(teacher)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("sonu/pages/education.edu")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

}
package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Course;
import com.raysi.springdatajpa.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveData(){
        Course course = Course.builder()
                .courseTitle("Java Spring Framework")
                .credit(10)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.github.com/2002Raysi")
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
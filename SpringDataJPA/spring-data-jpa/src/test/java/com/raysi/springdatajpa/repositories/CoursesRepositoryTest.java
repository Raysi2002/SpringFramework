package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Courses;
import com.raysi.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoursesRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourses(){
        List<Courses> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Aashish")
                .lastName("Ray")
                .build();
        Courses course = Courses.builder()
                .courseTitle("DBMS")
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}

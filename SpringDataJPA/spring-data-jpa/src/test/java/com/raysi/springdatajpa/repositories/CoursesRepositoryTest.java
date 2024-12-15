package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.CourseMaterial;
import com.raysi.springdatajpa.entities.Courses;
import com.raysi.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void Pagination(){
        Pageable pageable = PageRequest.of(0, 2);
        Pageable pageable1 = PageRequest.of(1, 2);
        List<Courses> coursesList = courseRepository.findAll(pageable1).getContent();
        Long totalElementInCourseTable = courseRepository.findAll(pageable).getTotalElements();
        coursesList.stream().forEach(System.out :: println);
        System.out.println("Total elements: " + totalElementInCourseTable);
    }

    @Test
    public void PaginationWithSorting(){
        Pageable pageable = PageRequest.of(0, 5, Sort.by("courseTitle").descending());
        List<Courses> coursesList = courseRepository.findAll(pageable).getContent();
        coursesList.stream().forEach(System.out :: println);
    }
}

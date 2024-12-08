package com.raysi.allrequesthandeling.controllers;

import com.raysi.allrequesthandeling.models.Students;
import com.raysi.allrequesthandeling.services.StudentService;
import com.raysi.allrequesthandeling.services.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService = new StudentServiceImplementation();

    @GetMapping("/stds")
    List<Students> studentData(){
        return studentService.fetchStudents();
    }

    @PostMapping("/post")
    String postStudents(@RequestBody Students std){
        studentService.uploadStudent(std);
        return "Student uploaded with id: " + std.getId();
    }

    @DeleteMapping("/delete/{id}")
    String deleteStudent(@PathVariable Long id){
        if(studentService.deleteStudent(id))
            return "Deleted successfully";
        return "Student not found";
    }

    @PutMapping("update/{id}")
    String updateStudentInfo(@PathVariable Long id,@RequestBody Students std){
        studentService.updateStudent(id, std);
        return std.toString();
    }
}

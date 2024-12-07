package com.raysi.requesthandeling.controllers;

import com.raysi.requesthandeling.services.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private Students students;

    List<Students> studentsList = new ArrayList<>();

    @GetMapping("/")
    public String homeInfo(){
        return """
                <h1> Welcome to home </h1>
                """;
    }

    @GetMapping("/students")
    public List<Students> sudentsInfo(){
        return studentsList;
    }

    @PostMapping("/post")
    public String postInfo(@RequestBody Students students){
        studentsList.add(students);
        return "Data received: " + students;
    }
}

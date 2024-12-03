package com.raysi.simplespringbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {
    @RequestMapping("/edu")
    public String eduInfo(){
        return """
                <h1>Education Information</h1>
                <p>School: Mithila Public School</p>
                <p>Percentage: 83%</p>
                <p>Diploma: Haryana State Board Of Technical Education</p>
                <p>Percentage: 86%</p>
                <p>Bachelor: Godavari Instuite of Engineering & Technology</p>
                <p>CGPA: 8.88</p>
                """;
    }
}

package com.raysi.serviceinspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @RequestMapping("/signup")
    public String signupPage(){
        return """
                Signup Page
                """;
    }
}

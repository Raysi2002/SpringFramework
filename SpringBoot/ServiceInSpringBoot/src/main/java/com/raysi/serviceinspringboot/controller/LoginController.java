package com.raysi.serviceinspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public String loginPage(){
        return """
                Login page
                """;
    }
}

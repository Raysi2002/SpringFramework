package com.raysi.allrequesthandeling.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return """
                <h1> Home Controller </h1>
                """;
    }
}

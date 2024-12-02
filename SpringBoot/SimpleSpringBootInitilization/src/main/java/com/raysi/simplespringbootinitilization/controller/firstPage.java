package com.raysi.simplespringbootinitilization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstPage {

    @RequestMapping("/")
    public String printHello(){
        return """
                <h1 style = text-align: centre> Welcome to my first page </h1>
                <h3> Details </h3>
                <p>Author: Aashish Ray <br> Number: 7762878177 </p>
                """;
    }
}

package com.raysi.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    String homePage(){
        return """
                <html>
                <head>
                    <title>Home Page</title>
                </head>
                <body>
                    <h1>Welcome to Home Page</h1>
                    <a href="http://localhost:8080/books">Books Data</a>
                    <h3>This is only for backend purpose</h3>
                    <a href="http://localhost:8080/">Post</a> <br> <br>
                    <a href="http://localhost:8080/">Update</a> <br> <br>
                    <a href="http://localhost:8080/">Delete</a>
                </body>
                </html>
                """;
    }
}

package com.raysi.booksmanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String homePage(){
        return """
                <head>
                    <title>Document</title>
                </head>
                <body>
                    <h1 style="text-align: center">Welcome to home page</h1>
                    <a href="http://localhost:8080/books">Click here To View Books</a> <br>
                    <a href="http://localhost:8080/post">Click here To View Books</a>
                </body>
                """;
    }
}

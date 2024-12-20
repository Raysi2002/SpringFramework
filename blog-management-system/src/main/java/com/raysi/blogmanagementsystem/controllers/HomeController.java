package com.raysi.blogmanagementsystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return """
                <title>Document</title>
                </head>
                <body>
                    <h1 style = "text-align : center">Welcome To The Blog Management System</h1>
                </body>
                </html>
                """;
    }
}

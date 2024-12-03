package com.raysi.simplespringbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/")
    public String greet(){
        return """
                <head>
                    <title>Simple Spring Boot Web</title>
                </head>
                <body>
                    <h1 style="text-align:center; font-family: 'Courier New', Courier, monospace; font-size:xxx-large;">Welcome User</h1>
                    <h2 style="color: purple; font-family: 'Courier New', Courier, monospace; font-size: xx-large;">Why Learn and Work with Spring Boot?</h2>
                    <p style="color: blue; font-family: 'Courier New', Courier, monospace; font-size: large;">
                        Spring Boot simplifies backend development, letting you focus on building robust applications without the hassle of complex configurations. Its tools enable rapid prototyping, seamless integration, and scalability, making it ideal for modern, production-ready projects. Mastering Spring Boot boosts productivity and opens doors to exciting career opportunities in enterprise-level development.
                     </p>
                </body>
                </html>
                """;
    }

    @RequestMapping("/about")
    public String aboutInfo(){
        return """
                <h1>Engineer Information</h1>
                <h3>Name: Aashish</h3>
                <h3>Contact No: +917762878177 / +9779848278176</h3>
                <h3>Email: 2002raysi@gmail.com</h3>
                <h3>Field: Full Stack Web Development</h3>
                """;
    }
}

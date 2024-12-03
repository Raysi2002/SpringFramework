# Spring Boot Simple Web Page

Here’s a concise theory section you can include in your learning.md file to help with quick revisions:

Spring Boot Controllers

	1.	What is a Controller?
	•	In Spring Boot, a controller is a class used to handle incoming HTTP requests and define how the application responds. It’s a key part of the Model-View-Controller (MVC) design pattern.
	2.	Annotations:
	•	@RestController: Combines @Controller and @ResponseBody, simplifying the development of RESTful APIs. The response is directly written to the HTTP response body in formats like JSON, XML, or plain text.
	•	@Controller: Used when returning HTML views or templates. Requires @ResponseBody for direct responses.
	3.	Mapping HTTP Requests:
	•	@RequestMapping: Maps HTTP requests to handler methods. Example:

```@RequestMapping("/example")
public String exampleMethod() {
return "Hello, Spring Boot!";
}```


	•	Supports path patterns (e.g., /login, /signup) and HTTP methods (GET, POST).

	4.	Response Formats:
	•	You can return plain text, HTML, or JSON. Use triple-quoted strings (Java Text Blocks) for HTML for better readability.
Example:

```return """
<h1>Hello, User!</h1>
<p>Welcome to Spring Boot</p>
""";```

Best Practices

	•	Separation of Concerns: Keep controllers lightweight. Use service classes for business logic.
	•	Avoid Redundancy: Reuse code by creating common methods or utility classes.
	•	Readable Code: Use consistent naming conventions for methods and meaningful endpoint names (e.g., /about, /edu).

Code Summary

	•	The provided examples showcase:
	1.	Basic @RestController and @Controller usage.
	2.	Returning HTML content using Text Blocks for dynamic pages.
	3.	Different routes for varied content (e.g., /about, /edu, /login).

This section provides an easy-to-grasp overview for revision.







## Controller
```
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

```

## Education Controller
```
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

```
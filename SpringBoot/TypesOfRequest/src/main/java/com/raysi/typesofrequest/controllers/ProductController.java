package com.raysi.typesofrequest.controllers;


import com.raysi.typesofrequest.models.Product;
import com.raysi.typesofrequest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String homePage(){
        return """
                <h1 style="text-align: center; font-family: 'American Typewriter',monospace; font-size: xxx-large">Welcome to Home Page</h1>
                """;
    }
}

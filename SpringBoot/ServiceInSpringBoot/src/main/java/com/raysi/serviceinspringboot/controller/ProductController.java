package com.raysi.serviceinspringboot.controller;

import com.raysi.serviceinspringboot.model.Product;
import com.raysi.serviceinspringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productList;

    @RequestMapping("/products")
    public List<Product> productInfo(){
        return productList.products();
    }
}

package com.raysi.serviceinspringboot.services;

import com.raysi.serviceinspringboot.model.Product;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> productList = Arrays.asList(new Product("Earbuds", "Tech", 99.99), new Product("Mobile", "Tech", 999.99));
    public List<Product> products(){
        return productList;
    }
}

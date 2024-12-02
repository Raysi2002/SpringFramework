package com.raysi.firstspringboot.primaryandqualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // Read info.md for proper details
public class Laptop implements Computer {
    @Override
    public String info(){
        return """
                Model: Macbook Air m2
                Display: 13.6 inch Super Retina Display
                Processor: Apple Silicon m2
                RAM: 8GB
                SSD: 256GB
                Brand: Apple
                Color: Black
                Price: INR 122500
                Monitor: 24 inch
                """;
    }
}

package com.raysi.firstspringboot.primaryandqualifier;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    @Override
    public String info() {
        return """
                Monitor: 24 inch
                Processor: i9 13th gen 13500h
                RAM: 8GB
                SSD: 256GB
                Brand: Apple
                Color: Black
                Price: INR 300000
                """;
    }
}

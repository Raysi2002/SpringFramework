package com.raysi.firstspringboot.primaryandqualifier;

import org.springframework.stereotype.Component;

@Component
public class PC implements Computer{
    @Override
    public String info(){
        return """
                Processor: i7 13th gen 13500h
                RAM: 8GB
                SSD: 256GB
                Brand: Apple
                Color: Black
                Price: INR 90000
                """;
    }
}

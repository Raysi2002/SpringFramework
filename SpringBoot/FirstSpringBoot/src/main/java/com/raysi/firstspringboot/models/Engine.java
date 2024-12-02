package com.raysi.firstspringboot.models;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public String engineInfo(){
        return """
                Engine-Model: V8
                Power: 200HP
                Brand: MBV
                """;
    }
}

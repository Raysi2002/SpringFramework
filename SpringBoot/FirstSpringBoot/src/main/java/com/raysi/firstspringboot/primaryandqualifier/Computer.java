package com.raysi.firstspringboot.primaryandqualifier;

import org.springframework.stereotype.Component;

@Component
public interface Computer { //Interface is a very good option for achieving Loose Coupling in Spring
    public String info();
}

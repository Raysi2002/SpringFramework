package com.raysi.firstspringboot.primaryandqualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developer {

    @Qualifier("laptop")
    private Computer computer;

    public Developer(Computer computer){
        this.computer = computer;
    }

    public String developerInfo(){
        return """
                Developer-Name: Aashish
                Location: Remote & On Site
                -----System Description-----
                """ + computer.info();
    }
}

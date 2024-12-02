package com.raysi.firstspringboot.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    //Read info.md file for all details about the dependency injection

//    @Autowired //Field Injection
    private Engine engine;

//    @Autowired //Setter Injection
//    public void setEngine(Engine engine){
//        this.engine = engine;
//    }


    //Constructor Injection
    public Car(Engine engine){
        this.engine = engine;
    }

    public String carInfo(){
        return  """
                Car Name: BMW AP116
                Color: Blue
                Type: EV
                """ + engine.engineInfo();
    }
}

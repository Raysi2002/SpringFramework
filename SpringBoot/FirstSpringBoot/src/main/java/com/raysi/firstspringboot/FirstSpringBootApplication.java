package com.raysi.firstspringboot;

import com.raysi.firstspringboot.primaryandqualifier.Developer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringBootApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(FirstSpringBootApplication.class, args);
//        Car car = context.getBean(Car.class);
//        System.out.println(car.carInfo());
        Developer developer = context.getBean(Developer.class);
        System.out.println(developer.developerInfo());
    }

}

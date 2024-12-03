package com.raysi;

import com.raysi.beans.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Developer developer = (Developer) context.getBean("developer");
//        System.out.println(developer.getName());
//        System.out.println(developer.getAge());
        developer.display();
    }
}

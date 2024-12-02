# @Primary and @Qualifier
 Look at these code snippets and we'll look forward with the help of these code snippets

# Points
- Computer interface is made to provide loose coupling instead of hard coding the objects
- Look at the classes Desktop, Laptop & PC, all of them has implemented Computer interface
- Just consider once, what will happen if our main class wanted to executed the Developer method which has property of Computer. Just think which out of those classes it will select ? 
- Here's the conflict arises for the Spring.
- In order to manage that, we use @Primary annotation that helps Spring in resolving conflicts
- The @Primary class method will be created in the scenerio of conflicts
- If we particulary wanted a specific class property then we mention the it's id with @Qualifier
## Note: The spring container automatically creates the name of class with small letter (Example: Laptop class then "laptop")

### Computer Interface
```
package com.raysi.firstspringboot.primaryandqualifier;

import org.springframework.stereotype.Component;

@Component
public interface Computer { //Interface is a very good option for achieving Loose Coupling in Spring
    public String info();
}

```

### Desktop.java
```
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
```

### Developer.java
```
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
```

### Laptop.java
```
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
```

### PC.java
```
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
```

### FirstSpringBootApplication.java
```
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
```
# SpringBoot Starter Information
## There are three (3) ways of dependency injection
1. Field Injection
2. Setter Injection
3. Constructor Injection

### Note : <span style="color: aqua;">Both the setter method and field method uses @Autowired annotation but it's not required in Constructor dependency injection</span>
### Note : <span style="color: aqua;">Try to avoid field injection as it's breaking encapsulation rule. Make habit of using constructor dependency injection</span>

### --------------<span style="color: red;">Field Injection</span>---------------

<span style="color: green">Suppose there are two classes and with the help of those two classes we will discuss about all the dependency injection method </span>


### Car.java
```
package com.raysi.firstspringboot.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private Engine engine;
    public String carInfo(){
        return  """
                Car Name: BMW AP116
                Color: Blue
                Type: EV
                """ + engine.engineInfo();
    }
}
```

### Engine.java
```
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
```

### --------------<span style="color: red;">Setter Injection</span>---------------

```
package com.raysi.firstspringboot.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    //Setter dependency injection
    @Autowired
    public void setEngine(Engine engine){
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

```

### --------------<span style="color: red;">Constructor Injection</span>---------------
```
package com.raysi.firstspringboot.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
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

```
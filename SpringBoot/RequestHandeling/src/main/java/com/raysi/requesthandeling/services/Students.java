package com.raysi.requesthandeling.services;

import lombok.*;
import org.springframework.stereotype.Component;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Component
public class Students {
    private int id;
    private String name;
    private float marks;

    public Students() {
    }

    public Students(int id, String name, float marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "id: " + id + "\tname: " + name + "\tmarks: " + marks;
    }
}

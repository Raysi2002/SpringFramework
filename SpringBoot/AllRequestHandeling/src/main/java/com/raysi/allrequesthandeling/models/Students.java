package com.raysi.allrequesthandeling.models;


import org.springframework.stereotype.Component;

@Component
public class Students {
    private int id;
    private String name;
    private float marks;
    private String domain;

    public Students() {
    }

    public Students(int id, String name, float marks, String domain) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.domain = domain;
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return id + name + marks + domain;
    }
}
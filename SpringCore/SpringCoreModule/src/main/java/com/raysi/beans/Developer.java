package com.raysi.beans;

public class Developer{
    private String name;
    private int age;
    private Computer computer;

    public Developer(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Developer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Developer(Computer computer) {
        this.computer = computer;
    }

    public void display(){
        System.out.println("Name: " + name );
        System.out.println("Age: " + age);
        System.out.println("Computer: " + computer);
    }

}

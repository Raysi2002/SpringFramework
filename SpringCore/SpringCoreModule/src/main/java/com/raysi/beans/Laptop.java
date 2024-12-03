package com.raysi.beans;

public class Laptop implements Computer{
    public Laptop(){
        System.out.println("Laptop class");
    }
    @Override
    public void compile() {
        System.out.println("Laptop is compiling");
    }
}

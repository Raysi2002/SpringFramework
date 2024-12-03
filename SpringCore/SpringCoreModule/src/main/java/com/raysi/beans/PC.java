package com.raysi.beans;

public class PC implements Computer{
    public PC(){
        System.out.println("PC class");
    }
    @Override
    public void compile() {
        System.out.println("PC is compiling");
    }
}

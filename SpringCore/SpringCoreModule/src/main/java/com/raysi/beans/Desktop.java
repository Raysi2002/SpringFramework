package com.raysi.beans;

public class Desktop implements Computer {
    public Desktop(){
        System.out.println("Computer class");
    }
    @Override
    public void compile(){
        System.out.println("Desktop is compiling");
    }
}

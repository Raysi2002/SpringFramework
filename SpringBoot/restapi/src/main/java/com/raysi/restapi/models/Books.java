package com.raysi.restapi.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Books {
    private Long id;
    private String name;
    @Autowired
    private Author author;
    private double price;

    public Books() {
    }

    public Books(Long id, String name, Author author, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setISBN(Long ISBN) {
        this.id = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nBook Name: " + name + "\nAuthor: " + author.toString() + "\nPrice: " + price;
    }
}

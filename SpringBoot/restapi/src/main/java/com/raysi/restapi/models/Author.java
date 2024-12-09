package com.raysi.restapi.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Author {
    private int authorId;
    private String  name;
    private String email;
    @Autowired
    private Address address;

    public Author() {
    }

    public Author(int authorId, String name, String email, Address address) {
        this.authorId = authorId;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nAuthor ID: " + authorId + "\nAuthor Name: " + name + "\nAuthor Email: " + email  + "\nAuthor Address: " + address.toString();
    }
}

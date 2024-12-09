package com.raysi.restapi.models;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private int pincode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(int pincode, String city, String country) {
        this.pincode = pincode;
        this.city = city;
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nPin code: " + pincode + "\nCity: " + city + "\nCountry: " + country;
    }
}

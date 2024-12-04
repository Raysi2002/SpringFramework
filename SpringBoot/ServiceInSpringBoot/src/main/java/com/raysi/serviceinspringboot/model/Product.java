package com.raysi.serviceinspringboot.model;
import org.springframework.stereotype.Component;


@Component
public class Product {
    private String prodName;
    private String prodDomain;
    private double prodPrice;

    public Product(){

    }

    public Product(String prodName, String prodDomain, double prodPrice) {
        this.prodName = prodName;
        this.prodDomain = prodDomain;
        this.prodPrice = prodPrice;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDomain() {
        return prodDomain;
    }

    public void setProdDomain(String prodDomain) {
        this.prodDomain = prodDomain;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }
}

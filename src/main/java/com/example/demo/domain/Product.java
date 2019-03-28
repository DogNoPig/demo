package com.example.demo.domain;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int i, String product_e, int i1) {
        this.id = i;
        this.name = product_e;
        this.price = i1;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

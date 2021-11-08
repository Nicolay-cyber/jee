package com.geekbrains.app;

public class Product {
    private String title;
    private int id;
    private int cost;

    public Product(String title, int id, int cost) {
        this.title = title;
        this.id = id;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "   " + title + " " + cost;
    }
}

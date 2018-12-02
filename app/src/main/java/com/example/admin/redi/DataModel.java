package com.example.admin.redi;


public class DataModel {

    String name;
    String image;

    public DataModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
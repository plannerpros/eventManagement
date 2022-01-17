package com.example.planner;

public class venueHelper {
    String name, image, cost;

    public venueHelper() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public venueHelper(String name, String image, String cost) {
        this.name = name;
        this.image = image;
        this.cost = cost;
    }
}






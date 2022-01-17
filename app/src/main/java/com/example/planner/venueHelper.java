package com.example.planner;

public class venueHelper {
    String name, image, location;

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
        return location;
    }

    public void setCost(String cost) {
        this.location = cost;
    }

    public venueHelper(String name, String image, String cost) {
        this.name = name;
        this.image = image;
        this.location = cost;
    }
}






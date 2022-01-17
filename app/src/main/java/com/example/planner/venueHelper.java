package com.example.planner;

public class venueHelper {
    String name, image, location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public venueHelper() {

    }

    public venueHelper(String name, String image, String location) {
        this.name = name;
        this.image = image;
        this.location = location;
    }
}






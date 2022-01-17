package com.example.planner;

public class displayVenue {
    public String name, location, noOfpeople, cost, image;

    public displayVenue() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoOfpeople() {
        return noOfpeople;
    }

    public void setNoOfpeople(String noOfpeople) {
        this.noOfpeople = noOfpeople;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public displayVenue(String name, String location, String noOfpeople, String cost, String image) {
        this.name = name;
        this.location = location;
        this.noOfpeople = noOfpeople;
        this.cost = cost;
        this.image = image;
    }
}

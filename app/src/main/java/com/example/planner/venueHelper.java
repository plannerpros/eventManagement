package com.example.planner;

public class venueHelper {
    String title, image, price;

    public venueHelper() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public venueHelper(String title, String image, String price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }
}




package com.example.planner;

public class imageHelper {
    String image,image1,image2;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public imageHelper(String image, String image1, String image2) {
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
    }
}

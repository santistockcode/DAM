package com.santi.pec3_sas;

//POJO, no need for a UUID for now since every name is different
public class Place {
    private String name;
    private int imageResourceId;
    private int ratingCount;

    public Place() {
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }
}

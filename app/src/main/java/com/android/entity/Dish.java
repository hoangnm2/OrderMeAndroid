package com.android.entity;

/**
 * Created by binhb on 12/11/2016.
 */

public class Dish {

    private String name;
    private Integer image;
    private String price;

    public Dish() {
    }

    public Dish(String name, Integer image, String price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

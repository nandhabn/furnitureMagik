package com.nandha.fmstore;

import android.net.Uri;

public class Furniture {
    private String name;
    private Uri uri;
    private String discription;
    private int price;
    private int deleveryCharge;

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public int     getPrice() {
        return price;
    }

    public int getDeleveryCharge() {
        return deleveryCharge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public void setDeleveryCharge(int deleveryCharge) {
        this.deleveryCharge = deleveryCharge;
    }
}
package com.parking.parkinglot.common;

import java.util.ArrayList;

public class CartDto {
    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductDto> products) {
        this.products = products;
    }

    float totalPrice;
    ArrayList<ProductDto> products = new ArrayList<>();
}

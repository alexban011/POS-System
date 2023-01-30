package com.parking.parkinglot.common;

public class ProductDto {
    Long id;
    Float price;
    Integer quantity;
    String category;

    public Long getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public ProductDto(Long id, Float price, Integer quantity, String category){
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}

package com.parking.parkinglot.common;

public class ProductDto {
    Long id;
    String name;
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

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public ProductDto(Long id, String name, Float price, Integer quantity, String category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}

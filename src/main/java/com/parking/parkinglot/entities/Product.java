package com.parking.parkinglot.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Float price;

    @Basic
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    private Integer quantity;

    @Basic
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private String category;

    @Basic
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private ProductPhoto photo;
    @OneToOne(mappedBy = "product", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    public ProductPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(ProductPhoto photo) {
        this.photo = photo;
    }
}

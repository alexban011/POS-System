package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.ProductDto;
import com.parking.parkinglot.entities.Product;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Stateful
@SessionScoped
public class CartBean implements Serializable {
    ArrayList<ProductDto> cart = new ArrayList<>();

    @PersistenceContext
    EntityManager entityManager;

    public ArrayList<ProductDto> getCart(){
        return cart;
    }

    public ArrayList<ProductDto> addProduct(Long productId){
        Product product = entityManager.find(Product.class,productId);
        cart.add(new ProductDto(product.getId(),product.getName(),product.getPrice(),product.getQuantity(),product.getCategory()));
        return cart;
    }

    public ArrayList<ProductDto> removeProduct(Long productId){
        cart = (ArrayList<ProductDto>) cart.stream().filter(x->x.getId()!=productId);
        return cart;
    }
}

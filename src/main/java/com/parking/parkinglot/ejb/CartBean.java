package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CartDto;
import com.parking.parkinglot.common.ProductDto;
import com.parking.parkinglot.entities.Product;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.ArrayList;

@Stateful
@SessionScoped
public class CartBean implements Serializable {
    CartDto cart = new CartDto();

    @PersistenceContext
    EntityManager entityManager;

    public CartDto getCart(){
        return cart;
    }

    public CartDto addProduct(Long productId){
        Product product = entityManager.find(Product.class,productId);
        ProductDto newProduct = new ProductDto(product.getId(),product.getName(),product.getPrice(),product.getQuantity(),product.getCategory());
        ArrayList<ProductDto> products = cart.getProducts();
        products.add(newProduct);

        cart.setProducts(products);
        cart.setTotalPrice(calculateTotal());
        return cart;
    }

    public CartDto removeProduct(Long productId){
        cart.setProducts((ArrayList<ProductDto>) cart.getProducts().stream().filter(x->x.getId()!=productId));
        cart.setTotalPrice(calculateTotal());
        return cart;
    }

    private float calculateTotal(){
        float sum = 0;
        for(ProductDto prod: cart.getProducts()){
            sum+=prod.getPrice();
        }
        return sum;
    }
}

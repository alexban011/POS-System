package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.CartDto;
import com.parking.parkinglot.common.ProductDto;
import com.parking.parkinglot.ejb.CartBean;
import com.parking.parkinglot.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER", "ADMIN"}))
@WebServlet(name = "Sell", value = "/Sell")
public class Sell extends HttpServlet {

    @Inject
    CartBean cartBean;
    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for(ProductDto product: cartBean.getCart().getProducts()){
            ProductDto prod = productsBean.findById(product.getId());
            productsBean.updateProduct(prod.getId(),prod.getName(), prod.getPrice(), prod.getQuantity()-1, prod.getCategory());
        }
        cartBean.emptyCart();
        CartDto cart = cartBean.getCart();

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
    }
}

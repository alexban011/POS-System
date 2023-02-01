package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.CartDto;
import com.parking.parkinglot.ejb.CartBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"CASHIER", "ADMIN"}))
@WebServlet(name = "Cart", value = "/Cart")
public class Cart extends HttpServlet {

    @Inject
    CartBean cartBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDto cart = cartBean.getCart();

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
    }


}
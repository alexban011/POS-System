package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.CartDto;
import com.parking.parkinglot.ejb.CartBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_CARS"}))
@WebServlet(name = "RemoveFromCart", value = "/RemoveFromCart")
public class RemoveFromCart extends HttpServlet {

    @Inject
    CartBean cartBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameterValues("productId")[0];
        CartDto cart = cartBean.removeProduct(Long.parseLong(productId));

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
    }
}

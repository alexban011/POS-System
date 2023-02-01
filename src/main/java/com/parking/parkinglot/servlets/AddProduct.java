package com.parking.parkinglot.servlets;

import com.parking.parkinglot.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {

    @Inject
    ProductsBean productsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Float price = Float.valueOf(request.getParameter("price"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        String category = request.getParameter("category");

        productsBean.createProduct(name, price, quantity, category);

        response.sendRedirect(request.getContextPath() + "/Products");
    }
}

package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.ProductDto;
import com.parking.parkinglot.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ADMIN"}))
@WebServlet(name = "EditProduct", value = "/EditProduct")
public class EditProduct extends HttpServlet {

    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDto productDto;
        String productId = request.getParameterValues("productId")[0];
        productDto = productsBean.findById(Long.parseLong(productId));
        request.setAttribute("product", productDto);
        request.getRequestDispatcher("/WEB-INF/pages/editProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Float price = Float.valueOf(request.getParameter("price"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        String category = request.getParameter("category");

        productsBean.updateProduct(id, name, price, quantity, category);

        response.sendRedirect(request.getContextPath() + "/Products");
    }
}

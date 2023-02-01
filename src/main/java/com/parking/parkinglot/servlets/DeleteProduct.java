package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.ProductDto;
import com.parking.parkinglot.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_CARS"}))
@WebServlet(name = "DeleteProduct", value = "/DeleteProduct")
public class DeleteProduct extends HttpServlet {

    @Inject
    ProductsBean productsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameterValues("productId")[0];
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(Long.parseLong(productId));
        productsBean.deleteProductsByIds(ids);

        List<ProductDto> products = productsBean.findAllProducts();

        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
    }
}

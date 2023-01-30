package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.ProductDto;
import com.parking.parkinglot.ejb.ProductsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "Products", value = "/Products")
public class Products extends HttpServlet {
    @Inject
    ProductsBean productsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDto> products = productsBean.findAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[]  productIdsAsString = request.getParameterValues("product_ids");
        if(productIdsAsString != null){
            List<Long> productIds = new ArrayList<>();
            for(String productIdAsString : productIdsAsString){
                productIds.add(Long.parseLong(productIdAsString));
            }
            productsBean.deleteProductsByIds(productIds);
        }
        response.sendRedirect(request.getContextPath()+"/Products");
    }
}

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

        String category = request.getParameter("category");
        List<ProductDto> categoryFilteredProducts = new LinkedList<>();
        int sizeForCategoryFilter = products.size();

        for (int i = 0; i < sizeForCategoryFilter; i++) {
            if (category == null || category.equals("all")) {
                categoryFilteredProducts = products;
                break;
            }

            if (Objects.equals(products.get(i).getCategory(), category)) {
                categoryFilteredProducts.add(products.get(i));
            }
        }

        String name = request.getParameter("name");
        List<ProductDto> nameFilteredProducts = new LinkedList<>();
        int sizeForNameFilter = categoryFilteredProducts.size();

        for (int i = 0; i < sizeForNameFilter; i++) {
            if (name == null || name.equals("")) {
                nameFilteredProducts = categoryFilteredProducts;
                break;
            }
            if (categoryFilteredProducts.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                nameFilteredProducts.add(products.get(i));
            }
        }

        request.setAttribute("products", nameFilteredProducts);
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath()+"/Products");
    }
}

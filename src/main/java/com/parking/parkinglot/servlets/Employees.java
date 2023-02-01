package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.EmployeeDto;
import com.parking.parkinglot.ejb.EmployeeBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"HR", "ADMIN"}))
@WebServlet(name = "Employees", value = "/Employees")
public class Employees extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeDto> employees = employeeBean.findAllEmployees();

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] employeeIds = request.getParameterValues("employeeId");

        try {
            employeeBean.deleteEmployeesByIds(Arrays.stream(employeeIds).map(x->Long.parseLong(x)).collect(Collectors.toSet()));
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (NotSupportedException e) {
            throw new RuntimeException(e);
        }

        List<EmployeeDto> employees = employeeBean.findAllEmployees();

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/pages/employees.jsp").forward(request, response);
    }
}

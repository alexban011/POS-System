package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.EmployeeDto;
import com.parking.parkinglot.ejb.EmployeeBean;
import com.parking.parkinglot.ejb.JobBean;
import com.parking.parkinglot.ejb.UserBean;
import com.parking.parkinglot.entities.Job;
import com.parking.parkinglot.entities.User;
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
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_CARS"}))
@WebServlet(name = "AddEmployee", value = "/AddEmployee")
public class AddEmployee extends HttpServlet {

    @Inject
    EmployeeBean employeeBean;
    @Inject
    UserBean userBean;
    @Inject
    JobBean jobBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeDto> employees = employeeBean.findAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/pages/addEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String jobTitle = request.getParameter("jobTitle");
        String salary = request.getParameter("salary");

        try {
            // TODO: validate user input
            User user = userBean.findById(username);
            Job job = jobBean.findByJobTitle(jobTitle);

            employeeBean.createEmployee(user, job, Long.valueOf(salary));
            jobBean.deleteJobById(job.getId());
        } catch (NamingException | SystemException | NotSupportedException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}

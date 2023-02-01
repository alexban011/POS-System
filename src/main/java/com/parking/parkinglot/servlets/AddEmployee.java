package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.EmployeeDto;
import com.parking.parkinglot.common.JobDto;
import com.parking.parkinglot.common.UserDto;
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

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"HR", "ADMIN"}))
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
        List<JobDto> jobs = jobBean.findAllJobs();
        List<UserDto> users = userBean.findAllUsers();

        request.setAttribute("jobs", jobs);
        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/pages/addEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String jobId = request.getParameter("jobId");
        String salary = request.getParameter("salary");

        employeeBean.createEmployee(Long.parseLong(userId), Long.parseLong(jobId), Long.parseLong(salary));

        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}

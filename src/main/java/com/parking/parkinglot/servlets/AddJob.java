package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.JobDto;
import com.parking.parkinglot.ejb.JobBean;
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
@WebServlet(name = "AddJob", value = "/AddJob")
public class AddJob extends HttpServlet {

    @Inject
    JobBean jobBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JobDto> jobs = jobBean.findAllJobs();
        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("/WEB-INF/pages/addJob.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jobTitle = request.getParameter("jobTitle");

        try {
            jobBean.createJob(jobTitle);
        } catch (NamingException | SystemException | NotSupportedException e) {
            // TODO: Add proper exception handling
            throw new RuntimeException(e);
        }

        response.sendRedirect(request.getContextPath() + "/Jobs");
    }
}

package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.JobDto;
import com.parking.parkinglot.ejb.JobBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Jobs", value = "/Jobs")
public class Jobs extends HttpServlet {

    @Inject
    JobBean jobBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JobDto> jobs = jobBean.findAllJobs();
        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("/WEB-INF/pages/jobs.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] jobIdsAsString = request.getParameterValues("job_ids");
        if (jobIdsAsString != null) {
            List<Long> carIds = new ArrayList<>();
            for (String jobIdAsString: jobIdsAsString) {
                carIds.add(Long.parseLong(jobIdAsString));
            }
            try {
                jobBean.deleteJobsByIds(carIds);
            } catch (NamingException | SystemException | NotSupportedException e) {
                // TODO: Add proper exception handling
                throw new RuntimeException(e);
            }
        }
        response.sendRedirect(request.getContextPath() + "/Jobs");
    }
}

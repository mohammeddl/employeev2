package com.employee.controller;

import com.employee.dao.JobOfferDAO;
import com.employee.dao.ApplicationDAO;
import com.employee.model.Candidate;
import com.employee.model.JobOffer;
import com.employee.model.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.hibernate.Session;

import java.io.IOException;


@WebServlet("/candidate")
public class CandidateController extends HttpServlet {

    private JobOfferDAO jobOfferDAO = new JobOfferDAO();
    private ApplicationDAO applicationDAO = new ApplicationDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Candidate candidate = (Candidate) session.getAttribute("candidate");
        if(candidate == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        request.setAttribute("jobOffers", jobOfferDAO.getAllPublishedJobOffers());
        request.getRequestDispatcher("candidate.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
                
        String action = request.getParameter("action");

        if ("apply".equals(action)) {
            applyForJob(request, response);
        }
    }

    private void applyForJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Candidate candidate = (Candidate) session.getAttribute("candidate");
        if (candidate == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String jobOfferIdStr = request.getParameter("jobOfferId");
        if (jobOfferIdStr == null || jobOfferIdStr.isEmpty()) {
            request.setAttribute("message", "Invalid job offer ID.");
            doGet(request, response);
            return;
        }
        int jobOfferId = Integer.parseInt(jobOfferIdStr);
        JobOffer jobOffer = jobOfferDAO.getJobOfferById(jobOfferId);

        if (jobOffer == null) {
            request.setAttribute("message", "Job offer not found.");
            doGet(request, response);
            return;
        }
        boolean hasApplied = applicationDAO.hasCandidateApplied(candidate.getId(), jobOfferId);
        if (hasApplied) {
            request.setAttribute("message", "You have already applied for this job offer.");
            doGet(request, response);
            return;
        }
        Application application = new Application(candidate, jobOffer, "Submitted");
        applicationDAO.createApplication(application);
        request.setAttribute("message", "Your application has been submitted successfully.");
        doGet(request, response);
    }
}

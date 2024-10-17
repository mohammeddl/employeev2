package com.employee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.employee.dao.ApplicationDAO;
import com.employee.dao.JobOfferDAO;
import com.employee.model.Application;
import com.employee.model.JobOffer;
import com.employee.model.Recruiter;
import com.employee.service.CandidateService;
import com.employee.service.JobOfferService;

@WebServlet("/recruiter")
public class RecruiterController extends HttpServlet {

    private JobOfferService jobOfferService;

    private ApplicationDAO applicationDAO = new ApplicationDAO();

    public void init() {
        jobOfferService = new JobOfferService();
        
    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                createJobOffer(req, res);
                break;
            case "update":
                updateJobOffer(req, res);
                break;
            case "delete":
                deleteJobOffer(req, res);
                break;
            default:
                // res.sendRedirect("error.jsp");
                break;
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "accepted":
                acceptApplication(req, res);
                
                break;
            case "rejected":
                rejectApplication(req, res);
                
                break;
        
            default:
            getAllJobOffers(req, res);
                break;
        }

        
        

        
    }



    public void createJobOffer(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");

        if (recruiter == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        JobOffer jobOffer = new JobOffer();
        jobOffer.setTitle(req.getParameter("title"));
        jobOffer.setDescription(req.getParameter("description"));
        jobOffer.setLocation(req.getParameter("location"));
        jobOffer.setStatus("in progress");
        jobOffer.setEndDate(req.getParameter("date"));
        jobOffer.setRecruiter(recruiter);
        jobOfferService.createJobOffer(jobOffer);
    }

    public void deleteJobOffer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");

        if (recruiter == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId(Integer.parseInt(req.getParameter("id")));
        jobOffer.setRecruiter(recruiter);
        jobOfferService.deleteJobOffer(jobOffer);

        List<JobOffer> jobOffers = jobOfferService.findAllJobOffers(recruiter);;
        req.setAttribute("jobOffers", jobOffers);
        req.getRequestDispatcher("recruiter.jsp").forward(req, resp);
    }

    public void updateJobOffer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
        if (recruiter == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        JobOffer jobOffer = new JobOffer();
        jobOffer.setId(Integer.parseInt(req.getParameter("jobId")));
        jobOffer.setTitle(req.getParameter("title"));
        jobOffer.setDescription(req.getParameter("description"));
        jobOffer.setLocation(req.getParameter("location"));
        jobOffer.setStatus(req.getParameter("status"));
        jobOffer.setEndDate(req.getParameter("date"));
        jobOffer.setRecruiter(recruiter);
        jobOfferService.updateJobOffer(jobOffer);
    }
    
    public void getAllJobOffers(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");


        if (recruiter == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        List<JobOffer> jobOffers = jobOfferService.findAllJobOffers(recruiter);;
        req.setAttribute("jobOffers", jobOffers);
        req.setAttribute("candidates", applicationDAO.findAll(recruiter));
        req.getRequestDispatcher("recruiter.jsp").forward(req, resp);
    }

    public void rejectApplication(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
        if (recruiter == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        int applicationId = Integer.parseInt(req.getParameter("id"));
        Application application = applicationDAO.findApplicationById(applicationId);
        application.setStatus("rejected");
        applicationDAO.updateApplication(application);
        List<JobOffer> jobOffers = jobOfferService.findAllJobOffers(recruiter);;
        req.setAttribute("jobOffers", jobOffers);
        req.setAttribute("candidates", applicationDAO.findAll(recruiter));
        req.getRequestDispatcher("recruiter.jsp").forward(req, resp);
    }

    public void acceptApplication(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
        if (recruiter == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        int applicationId = Integer.parseInt(req.getParameter("id"));

        Application application = applicationDAO.findApplicationById(applicationId);
        application.setStatus("accepted");
        applicationDAO.updateApplication(application);
        List<JobOffer> jobOffers = jobOfferService.findAllJobOffers(recruiter);;
        req.setAttribute("jobOffers", jobOffers);
        req.setAttribute("candidates", applicationDAO.findAll(recruiter));
        req.getRequestDispatcher("recruiter.jsp").forward(req, resp);
    }

}

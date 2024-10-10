package com.employee.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.employee.model.JobOffer;
import com.employee.model.Recruiter;
import com.employee.service.JobOfferService;

@WebServlet("/recruiter")
public class RecruiterController extends HttpServlet {

    private JobOfferService jobOfferService;

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
                // updateJobOffer(req, res);
                break;
            case "delete":
                deleteJobOffer(req, res);
                break;
            default:
                // res.sendRedirect("error.jsp");
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

        req.setAttribute("message", jobOffer);
        req.getRequestDispatcher("recruiter.jsp").forward(req, resp);
    }

    
}

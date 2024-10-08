package com.employee.model;

import javax.persistence.*;


@Entity
public class JobOffer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    public JobOffer(String title, String description, Recruiter recruiter) {
        this.title = title;
        this.description = description;
        this.recruiter = recruiter;
    }

    public JobOffer() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }



    
}

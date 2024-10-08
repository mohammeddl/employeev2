package com.employee.model;
import java.util.List;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Recruiter extends User {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<JobOffer> jobOffers;
    public Recruiter(String name, String email, String password, String role, Date birthDate, String phoneNumber, String address) {
        super(name, email, password, role, birthDate, phoneNumber, address);
    }
    
    public Recruiter() {
    }


    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOffer> jobOffers) {
        this.jobOffers = jobOffers;
    }
}

package com.employee.model;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Candidate extends User {
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "candidate")
    private List<Application> applications;

    public Candidate(String name, String email, String password, String role, Date birthDate,String phoneNumber, String address) {
        super(name, email, password, role, birthDate, phoneNumber, address);
    }

    public Candidate() {
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    
    
}

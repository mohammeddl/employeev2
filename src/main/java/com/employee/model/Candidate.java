package com.employee.model;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Candidate extends User {

    public Candidate(String name, String email, String password, String role, Date birthDate,String phoneNumber, String address) {
        super(name, email, password, role, birthDate, phoneNumber, address);
    }

    public Candidate() {
    }

    
    
}

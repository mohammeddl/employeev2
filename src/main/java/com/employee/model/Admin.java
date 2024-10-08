package com.employee.model;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Admin extends User {

    public Admin(String name, String email, String password, String role, Date birthDate, String phoneNumber, String address) {
        super(name, email, password, role, birthDate, phoneNumber, address);
    }

    public Admin() {
    }

   

    

    
    
}

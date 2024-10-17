package com.employee.controller;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.employee.model.Admin;
import com.employee.model.Employee;
import com.employee.model.Recruiter;
import com.employee.util.EmailService;

import java.util.Date;
public class Main {
    

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee("med Doe", "tes5@gmail.com", "password" , "EMPLOYEE", new Date(), "2023-10-01", 50000.0, "Developer", "IT", "123456789", "555-1234", "123 Street");

        // Admin admin = new Admin("daali", "daali@admin.com", "password", "ADMIN", new Date(), "2023-10-01", "hay mghib arabi ");
        Recruiter recruiter = new Recruiter("med", "dfdf@test.com", "password", "RECRUITER", new Date(), "2023-10-01", "hay mghib arabi");
        em.persist(recruiter);

        em.getTransaction().commit();   
        em.close();
        emf.close();

       
    }
}

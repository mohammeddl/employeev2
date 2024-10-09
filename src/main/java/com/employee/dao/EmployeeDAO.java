package com.employee.dao;

import javax.persistence.EntityManager;

import com.employee.model.Employee;
import com.employee.util.JPAUtil;

public class EmployeeDAO implements GenericDAO<Employee> {

    private EntityManager em;

    public EmployeeDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void create(Employee employee) {
        try {
            em.getTransaction().begin();
            em.persist(employee);       
            em.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void update(Employee employee) {
        try {
            em.getTransaction().begin(); 
            em.merge(employee);          
            em.getTransaction().commit(); 
            
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
        }
    }

    @Override
    public void delete(Employee employee) {
        try {
            em.getTransaction().begin(); 
            employee = em.merge(employee);
            em.remove(employee);
            em.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
        }
    }

    
    
}

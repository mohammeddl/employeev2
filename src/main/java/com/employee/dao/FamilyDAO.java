package com.employee.dao;

import javax.persistence.EntityManager;

import com.employee.model.Employee;
import com.employee.model.Family;
import com.employee.util.JPAUtil;

public class FamilyDAO {

    private EntityManager em;

    public FamilyDAO(){
        this.em = JPAUtil.getEntityManager();
    }

    public void create(Family family){
        try {
            em.getTransaction().begin();
            em.persist(family);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void update(Family family){
        try {
            em.getTransaction().begin();
            em.merge(family);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    } 

    // find family by  employee_id 
    public Family findById(Employee employee){
        return em.createQuery("SELECT f FROM Family f WHERE f.employee = :employee", Family.class)
                .setParameter("employee", employee)
                .getSingleResult();
        
    }



    
}

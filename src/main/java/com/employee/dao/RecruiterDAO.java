package com.employee.dao;
import javax.persistence.EntityManager;

import com.employee.model.Recruiter;
import com.employee.util.JPAUtil;

public class RecruiterDAO implements GenericDAO<Recruiter> {

    private EntityManager em;

    public RecruiterDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void create(Recruiter recruiter) {
        try {
            em.getTransaction().begin();
            em.persist(recruiter);       
            em.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void update(Recruiter recruiter) {
        try{
            em.getTransaction().begin();
            em.merge(recruiter);
            em.getTransaction().commit();
         }catch(Exception e){
             e.printStackTrace();
             if(em.getTransaction().isActive()){
                 em.getTransaction().rollback();
             }
            }
    }

    @Override
    public void delete(Recruiter recruiter) {

        try{
            em.getTransaction().begin();
            recruiter = em.merge(recruiter);
            em.remove(recruiter);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
    }

    
}

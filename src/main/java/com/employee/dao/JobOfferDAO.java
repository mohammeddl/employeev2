package com.employee.dao;

import javax.persistence.EntityManager;

import com.employee.model.JobOffer;
import com.employee.util.JPAUtil;

public class JobOfferDAO implements GenericDAO<JobOffer> {

    private EntityManager em;

    public JobOfferDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void create(JobOffer jobOffer) {
        try {
            em.getTransaction().begin();
            em.persist(jobOffer);       
            em.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void update(JobOffer jobOffer) {
        try {
            em.getTransaction().begin(); 
            em.merge(jobOffer);          
            em.getTransaction().commit(); 
            
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
        }
    }

    @Override
    public void delete(JobOffer jobOffer) {
        try{
            em.getTransaction().begin();
            JobOffer jobOfferToDelete = em.find(JobOffer.class, jobOffer.getId());
            em.remove(jobOfferToDelete);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
    }

   
    
}

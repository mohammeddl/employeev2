package com.employee.dao;

import javax.persistence.EntityManager;

import com.employee.model.Candidate;
import com.employee.util.JPAUtil;

public class CandidateDAO implements GenericDAO<Candidate> {

    private EntityManager em;

    public CandidateDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void create(Candidate candidate) {
        try {
            em.getTransaction().begin();
            em.persist(candidate);       
            em.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
       
    }

    @Override
    public void update(Candidate entity) {
       try{
           em.getTransaction().begin();
           em.merge(entity);
           em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
    
    }

    @Override
    public void delete(Candidate entity) {
        try{
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.remove(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
    }
    
}

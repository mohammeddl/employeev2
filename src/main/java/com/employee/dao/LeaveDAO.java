package com.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.employee.model.Leave;
import com.employee.util.JPAUtil;

public class LeaveDAO {
    
    private EntityManager em;

    public LeaveDAO(){
         this.em = JPAUtil.getEntityManager();
    }

    public void create(Leave leave){
        try {
            em.getTransaction().begin();
            em.persist(leave);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void update(Leave leave){
        try {
            em.getTransaction().begin();
            em.merge(leave);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public Leave findById(int id){
        return em.find(Leave.class, id);
    }

    public List<Leave> findByEmployeeId(int employeeId){
        return em.createQuery("SELECT l FROM Leave l WHERE l.employee.id = :employeeId", Leave.class)
                .setParameter("employeeId", employeeId)
                .getResultList();
    }

    public List<Leave> findAll(){
        return em.createQuery("SELECT l FROM Leave l", Leave.class).getResultList();
    }

   
}

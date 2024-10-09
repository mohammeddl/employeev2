package com.employee.dao;

import javax.persistence.EntityManager;

import com.employee.util.JPAUtil;

import java.util.List;

public class UserDAO implements GenericDAO<Object> {
    
    private EntityManager em;

    public UserDAO() {
        this.em = JPAUtil.getEntityManager();
    }

        public Object findById(int id) {
            // Implementation here
            return null;
        }

        public List<Object> findAll() {
            // Implementation here
            return null;
        }
    
        @Override
        public void create(Object entity) {
            // Implementation here
        }
    
        @Override
        public void update(Object entity) {
            // Implementation here
        }
    
        @Override
        public void delete(Object entity) {
            // Implementation here
        }
    

}

package com.employee.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.employee.model.User;
import com.employee.util.JPAUtil;

import java.util.List;

public class UserDAO  {

    private EntityManager em;

    public UserDAO() {
        this.em = JPAUtil.getEntityManager();
    }

    public User findByEmailAndPassword(String email, String password) {
        try {
            User user = em
                    .createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
            System.out.println("lksjafsldkfhsjdkafhsakjdf hafkjasdhf ksadjfhksdjafh kasdjhflksd hfkjshfd kal" + user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    public User findByEmail(String email) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        List<User> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public List<Object> findAll() {
        // Implementation here
        return null;
    }

    public void create(User user) {
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();

        }
    }

  

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.ejb.bl;

import com.southnews.entities.Role;
import com.southnews.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thabi
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "SouthNewsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    @Override
    public User findByUsername(String username) {
        try {
            return em.createNamedQuery("User.findByUsername", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return em.createNamedQuery("User.findByEmail", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        User user = em.find(User.class, userId);
        if (user != null) {
            em.remove(user);
        }
    }
    
    @Override
    public List<User> findByRole(Role role) {
        return em.createQuery("SELECT u FROM User u WHERE u.role = :role", 
                User.class)
                .setParameter("role", role)
                .getResultList();
    }
}

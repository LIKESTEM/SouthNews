/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.ejb.bl;

import com.southnews.entities.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thabi
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {

    @PersistenceContext(unitName = "SouthNewsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
    @Override
    public Category findByName(String name) {
        return em.createNamedQuery("Category.findByName", Category.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    
}

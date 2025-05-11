/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.ejb.bl;

import com.southnews.entities.Comment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thabi
 */
@Stateless
public class CommentFacade extends AbstractFacade<Comment> implements CommentFacadeLocal {

    @PersistenceContext(unitName = "SouthNewsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }

    @Override
    public List<Comment> findByArticle(Long articleId) {
        return em.createNamedQuery("Comment.findByArticle", Comment.class)
                .setParameter("articleId", articleId)
                .getResultList();
    }

    @Override
    public List<Comment> findByUser(Long userId) {
        return em.createNamedQuery("Comment.findByUser", Comment.class)
                .setParameter("userId", userId)
                .getResultList();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.ejb.bl;

import com.southnews.entities.Article;
import com.southnews.entities.Status;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thabi
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article> implements ArticleFacadeLocal {

    @PersistenceContext(unitName = "SouthNewsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    
    // My Code:
    
    @Override
    public void deleteArticle(Long articleId) {
        Article article = em.find(Article.class, articleId);
        if (article != null) {
            em.remove(article);
        }
    }

    @Override
    public List<Article> getApprovedArticles() {
        return em.createNamedQuery("Article.findByStatus", Article.class)
                .setParameter("status", Status.APPROVED)
                .getResultList();
    }

    @Override
    public List<Article> getPendingArticles() {
        return em.createNamedQuery("Article.findByStatus", Article.class)
                .setParameter("status", Status.PENDING)
                .getResultList();
    }

    @Override
    public List<Article> getArticlesByCategory(Long categoryId) {
        return em.createNamedQuery("Article.findByCategory", Article.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Article> getArticlesByAuthor(Long authorId) {
        return em.createNamedQuery("Article.findByAuthor", Article.class)
                .setParameter("authorId", authorId)
                .getResultList();
    }

    @Override
    public Article getArticleById(Long articleId) {
        return em.find(Article.class, articleId);
    }

    @Override
    public Article approveArticle(Long articleId) {
        Article article = getArticleById(articleId);
        if (article != null) {
            article.setStatus(Status.APPROVED);
            return em.merge(article);
        }
        return null;
    }

    @Override
    public Article rejectArticle(Long articleId) {
        Article article = getArticleById(articleId);
        if (article != null) {
            article.setStatus(Status.REJECTED);
            return em.merge(article);
        }
        return null;
    }

    @Override
    public List<Article> findByStatus(Status status) {
        return em.createNamedQuery("Article.findByStatus", Article.class)
                .setParameter("status", status)
                .getResultList();}

    @Override
    public List<Article> findByCategory(Long categoryId) {
        return em.createNamedQuery("Article.findByCategory", Article.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Article> findByAuthor(Long authorId) {
        return em.createNamedQuery("Article.findByAuthor", Article.class)
                .setParameter("authorId", authorId)
                .getResultList();
    }

    @Override
    public List<Article> searchArticles(String searchTerm) {
        return em.createQuery(
            "SELECT a FROM Article a WHERE LOWER(a.title) LIKE :term OR LOWER(a.content) LIKE :term", 
            Article.class)
                .setParameter("term", "%" + searchTerm.toLowerCase() + "%")
                .getResultList();
    }
    
}

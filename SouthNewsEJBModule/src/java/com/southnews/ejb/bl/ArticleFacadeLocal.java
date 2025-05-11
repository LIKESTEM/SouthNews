/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.ejb.bl;

import com.southnews.entities.Article;
import com.southnews.entities.Status;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thabi
 */
@Local
public interface ArticleFacadeLocal {

    void create(Article article);

    void edit(Article article);

    void remove(Article article);

    Article find(Object id);

    List<Article> findAll();

    List<Article> findRange(int[] range);

    int count();
    
    void deleteArticle(Long articleId);
    
    List<Article> getApprovedArticles();
    
    List<Article> getPendingArticles();
    
    List<Article> getArticlesByCategory(Long categoryId);
    
    List<Article> getArticlesByAuthor(Long authorId);
    
    Article getArticleById(Long articleId);
    
    Article approveArticle(Long articleId);
    
    Article rejectArticle(Long articleId);
    
    // More methods
    
    List<Article> findByStatus(Status status);
    
    List<Article> findByCategory(Long categoryId);
    
    List<Article> findByAuthor(Long authorId);
    
    List<Article> searchArticles(String searchTerm);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.ejb.bl;

import com.southnews.entities.Comment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thabi
 */
@Local
public interface CommentFacadeLocal {

    void create(Comment comment);

    void edit(Comment comment);

    void remove(Comment comment);

    Comment find(Object id);

    List<Comment> findAll();

    List<Comment> findRange(int[] range);

    int count();
    
    List<Comment> findByArticle(Long articleId);
    
    List<Comment> findByUser(Long userId);
    
}

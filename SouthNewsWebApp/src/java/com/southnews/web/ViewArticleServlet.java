/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.ArticleFacadeLocal;
import com.southnews.ejb.bl.CommentFacadeLocal;
import com.southnews.entities.Article;
import com.southnews.entities.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thabi
 */
public class ViewArticleServlet extends HttpServlet {

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private CommentFacadeLocal commentFacade;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Long articleId = Long.parseLong(request.getParameter("id"));

        Article article = articleFacade.find(articleId);
        List<Comment> comments = commentFacade.findByArticle(articleId);

        request.setAttribute("article", article);
        request.setAttribute("comments", comments);
        request.getRequestDispatcher("ViewArticle.jsp").forward(request, response);
    }
}

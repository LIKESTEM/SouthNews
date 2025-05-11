/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.ArticleFacadeLocal;
import com.southnews.ejb.bl.CommentFacadeLocal;
import com.southnews.ejb.bl.UserFacadeLocal;
import com.southnews.entities.Article;
import com.southnews.entities.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thabi
 */
public class CommentServlet extends HttpServlet {

    @EJB
    private CommentFacadeLocal commentFacade;

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private UserFacadeLocal userFacade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        com.southnews.entities.User user = (com.southnews.entities.User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Long articleId = Long.parseLong(request.getParameter("articleId"));
        String content = request.getParameter("content");

        Article article = articleFacade.find(articleId);
        Comment comment = new Comment(article, user, content);

        commentFacade.create(comment);
        response.sendRedirect("ViewArticleServlet.do?id=" + articleId);
    }
}

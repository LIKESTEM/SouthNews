/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.ArticleFacadeLocal;
import com.southnews.entities.Article;
import com.southnews.entities.Status;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thabi
 */
public class ApproveArticleServlet extends HttpServlet {

    @EJB
    private ArticleFacadeLocal articleFacade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Long articleId = Long.parseLong(request.getParameter("articleId"));
        String action = request.getParameter("action");

        Article article = articleFacade.find(articleId);
        if ("approve".equals(action)) {
            article.setStatus(Status.APPROVED);
        } else if ("reject".equals(action)) {
            article.setStatus(Status.REJECTED);
        }
        articleFacade.edit(article);
        response.sendRedirect("AdminDashboardServlet.do");
    }
    
}

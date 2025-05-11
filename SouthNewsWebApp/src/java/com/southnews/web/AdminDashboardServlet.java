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
public class AdminDashboardServlet extends HttpServlet {

    @EJB
    private ArticleFacadeLocal articleFacade;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Article> pendingArticles = articleFacade.findByStatus(Status.PENDING);
        request.setAttribute("pendingArticles", pendingArticles);
        request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
    }
}

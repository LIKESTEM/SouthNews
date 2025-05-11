/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.ArticleFacadeLocal;
import com.southnews.entities.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class ArticleServlet extends HttpServlet {

    @EJB
    private ArticleFacadeLocal afl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        List<Article> articles = new ArrayList<>();
        session.setAttribute("articles", articles);
        request.getRequestDispatcher("home.jsp")
                .forward(request, response);
    }
}

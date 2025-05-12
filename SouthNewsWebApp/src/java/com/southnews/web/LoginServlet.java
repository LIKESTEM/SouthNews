/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.ArticleFacadeLocal;
import com.southnews.ejb.bl.CategoryFacadeLocal;
import com.southnews.ejb.bl.UserFacadeLocal;
import com.southnews.entities.Article;
import com.southnews.entities.Category;
import com.southnews.entities.Role;
import com.southnews.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
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
public class LoginServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal ufl;
    
    @EJB
    private ArticleFacadeLocal afl;
    
    @EJB
    private CategoryFacadeLocal cfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = ufl.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String url = getUrl(session, user);
            request.getRequestDispatcher(url)
                    .forward(request, response);
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
    
    public String getUrl(HttpSession session, User user) {
        String next = "index.html";
        
        if(user.getRole() == Role.ADMIN) {
            List<Article> pendingArticles = afl.getPendingArticles();
            
            session.setAttribute("pendingArticles", pendingArticles);
            
            next = "AdminDashboard.jsp";
        } else if(user.getRole() == Role.JOURNALIST) {
            List<Category> categories = cfl.findAll();
            
            session.setAttribute("categories", categories);
            
            next = "PostArticle.jsp";
        }
        
        return next;
    }
}

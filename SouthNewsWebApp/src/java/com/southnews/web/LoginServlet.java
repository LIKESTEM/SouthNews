/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.UserFacadeLocal;
import com.southnews.entities.User;
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
public class LoginServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal ufl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = ufl.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}

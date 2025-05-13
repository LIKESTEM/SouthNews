/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.UserFacadeLocal;
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

/**
 *
 * @author thabi
 */
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal ufl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> list = ufl.findAll();
        
        if(list == null || list.isEmpty()) {
            String username = "username";
            String email = "email_address";
            String cellNo = "phone_number";
            String password = "password";
            Role role = Role.ADMIN;

            User user = new User(username, email, cellNo, password, role);
            ufl.create(user);
        }
        
        response.sendRedirect("login.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String cellNo = request.getParameter("cellNo");
        String password = request.getParameter("password");
        Role role = Role.valueOf(request.getParameter("role"));

        User user = new User(username, email, cellNo, password, role);
        ufl.create(user);

        response.sendRedirect("login.jsp");
    }

}

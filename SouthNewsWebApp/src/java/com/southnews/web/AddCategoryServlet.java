/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.ejb.bl.CategoryFacadeLocal;
import com.southnews.entities.Category;
import com.southnews.entities.Role;
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
public class AddCategoryServlet extends HttpServlet {

    @EJB
    private CategoryFacadeLocal categoryFacade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        com.southnews.entities.User user = (com.southnews.entities.User) session.getAttribute("user");

        if (user == null || user.getRole() != Role.ADMIN) {
            response.sendRedirect("login.jsp");
            return;
        }

        String name = request.getParameter("name").trim();
        if (name != null && !name.isEmpty()) {
            Category category = new Category(name);
            categoryFacade.create(category);
        }

        response.sendRedirect("AddCategory.jsp");
    }
}

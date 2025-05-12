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
import com.southnews.entities.Status;
import com.southnews.entities.User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author thabi
 */

@MultipartConfig
public class PostArticleServlet extends HttpServlet {

    @EJB
    private ArticleFacadeLocal articleFacade;

    @EJB
    private CategoryFacadeLocal categoryFacade;

    @EJB
    private UserFacadeLocal userFacade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        User author = (User) session.getAttribute("user");

        if (author == null || author.getRole() != Role.JOURNALIST) {
            response.sendRedirect("login.jsp");
            return;
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        Part imagePart = request.getPart("image");
        InputStream imageIS = imagePart.getInputStream();
        
        byte[] image = getByte(imageIS);
        
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));

        Category category = categoryFacade.find(categoryId);
        Article article = new Article(title, content, category, image, author, new Date(), Status.PENDING);

        articleFacade.create(article);
        response.sendRedirect("PostArticle.jsp");
    }
    
    private byte[] getByte(InputStream imageIS) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int data;
        
        while((data = imageIS.read(bytes)) != -1) {
            baos.write(bytes, 0, data);
        }
        
        baos.flush();
        
        return baos.toByteArray();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Category> categories = categoryFacade.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("PostArticle.jsp").forward(request, response);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.web;

import com.southnews.model.EmailSender;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thabi
 */
public class SendContactFormServlet extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String toEmail = request.getParameter("email"); // Get recipient's email from form
        String name = request.getParameter("name");
        
        String bodyContent = request.getParameter("message");

        // Send email
        EmailSender.sendEmail(toEmail, "Received receipt", 
                "Good day, " + name + ".\n\n" +
                        "Kindly note that we have received your message. "
                        + "We will get back to you soon.\n\nYour message: "
                        + "[" + bodyContent + "]"
                                + "\n\nKind regards, \nSouthNews");
        
        response.sendRedirect("index.html");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.southnews.model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author thabi
 */
public class EmailSender {
    
    public static void sendEmail(String toEmail, String subject, String bodyContent) {
        // Set up mail server properties
        String host = "smtp.gmail.com"; // or use your SMTP server
        String port = "587"; // Gmail's SMTP port (adjust if needed)
        
        // your-email@gmail.com
        final String username = "your-email@gmail.com"; // Your email address
        
        // your-email-password
        final String password = "your-email-password"; // Your email password

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Create a session with the properties
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Set the sender's email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // Set the recipient's email address
            message.setSubject(subject); // Set the email subject
            message.setText(bodyContent); // Set the email body content

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error sending email.");
        }
    }
}

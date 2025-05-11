<%-- 
    Document   : ViewArticle
    Created on : 11 May 2025, 4:17:18 PM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.southnews.entities.Article, com.southnews.entities.Comment, java.util.List" %>
<%@ page session="true" %>
<%
    Article article = (Article) request.getAttribute("article");
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
    com.southnews.entities.User user = (com.southnews.entities.User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=article.getTitle()%></title>
    </head>
    <body>
        <h2><%= article.getTitle() %></h2>
        <p><%= article.getContent() %></p>
        <p><em>Category:</em> <%= article.getCategory().getName() %> | 
           <em>Author:</em> <%= article.getAuthor().getUsername() %> | 
           <em>Date:</em> <%= article.getCreatedAt() %></p>

        <hr>
        <h3>Comments</h3>
        <%
            for (Comment c : comments) {
        %>
            <p><strong><%= c.getUser().getUsername() %>:</strong> <%= c.getContent() %></p>
        <%
            }
        %>

        <% if (user != null) { %>
            <form action="CommentServlet.do" method="post">
                <input type="hidden" name="articleId" value="<%= article.getId() %>"/>
                <textarea name="content" rows="4" cols="60" required></textarea><br/>
                <input type="submit" value="Post Comment"/>
            </form>
        <% } else { %>
            <p><a href="login.jsp">Login</a> to comment.</p>
        <% } %>
    </body>
</html>

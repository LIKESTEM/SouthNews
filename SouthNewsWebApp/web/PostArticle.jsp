<%-- 
    Document   : PostArticle
    Created on : 11 May 2025, 2:56:56 PM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.southnews.entities.Category, java.util.List" %>
<%@ page session="true" %>
<%
    com.southnews.entities.User user = (com.southnews.entities.User) session.getAttribute("user");
    if (user == null || !user.getRole().toString().equals("JOURNALIST")) {
        response.sendRedirect("login.jsp");
        return;
    }
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Article</title>
    </head>
    <body>
        <h2>Post a New Article</h2>
        <form action="PostArticleServlet.do" method="post">
            Title: <input type="text" name="title" required/><br/>
            Category:
            <select name="categoryId">
                <%
                    for (Category cat: categories) {
                %>
                <option value="<%=cat.getId()%>"><%=cat.getName()%></option>
                <%
                    }
                %>
            </select><br/>
            Content:<br/>
            <textarea name="content" rows="10" cols="50" required></textarea><br/>
            <input type="submit" value="Submit Article"/>
        </form>
    </body>
</html>


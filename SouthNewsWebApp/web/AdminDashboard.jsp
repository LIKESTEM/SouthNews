<%-- 
    Document   : AdminDashboard
    Created on : 11 May 2025, 3:41:48 PM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.southnews.entities.Article, java.util.List" %>
<%@ page session="true" %>
<%
    com.southnews.entities.User user = (com.southnews.entities.User) session.getAttribute("user");
    if (user == null || !user.getRole().toString().equals("ADMIN")) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Article> pendingArticles = (List<Article>) request.getAttribute("pendingArticles");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <h2>Pending Articles for Review</h2>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Actions</th>
            </tr>
            <%
                for (Article a : pendingArticles) {
            %>
            <tr>
                <td><%= a.getTitle() %></td>
                <td><%= a.getAuthor().getUsername() %></td>
                <td>
                    <form action="ApproveArticleServlet.do" method="post" style="display:inline;">
                        <input type="hidden" name="articleId" value="<%= a.getId() %>" />
                        <button name="action" value="approve">Approve</button>
                        <button name="action" value="reject">Reject</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>

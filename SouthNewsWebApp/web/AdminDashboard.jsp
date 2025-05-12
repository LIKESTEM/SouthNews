<%-- 
    Document   : AdminDashboard
    Created on : 11 May 2025, 3:41:48 PM
    Author     : thabi
--%>

<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.southnews.entities.Article, java.util.List" %>
<%@ page session="true" %>
<%
    com.southnews.entities.User user = (com.southnews.entities.User) session.getAttribute("user");
    if (user == null || !user.getRole().toString().equals("ADMIN")) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Article> pendingArticles = (List<Article>) session.getAttribute("pendingArticles");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <jsp:include page="AdminNavBar.jsp" />
        
        <div class="container mt-5" style="padding-top: 3rem;">
            <h2 class="text-center mb-4">Pending Articles for Review</h2>

            <%
                if(pendingArticles != null && !pendingArticles.isEmpty()) {
            %>
            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>Title</th>
                            <th>Content</th>
                            <th>Category</th>
                            <th>Image</th>
                            <th>Status</th>
                            <th>Created Date</th>
                            <th>Author</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Article a : pendingArticles) {
                                String base64 = Base64.getEncoder().encodeToString(a.getImage());
                                String imagePath = "data:image/jpg;base64," + base64;
                        %>
                        <tr>
                            <td><%= a.getTitle() %></td>
                            <td><%= a.getContent() %></td>
                            <td><%= a.getCategory().getName() %></td>
                            <td><img src="<%=imagePath%>" alt="Related to article image" class="img-thumbnail" style="max-width:100px; max-height:100px;"/></td>
                            <td><%= a.getStatus().toString() %></td>
                            <td><%= a.getCreatedAt() %></td>
                            <td><%= a.getAuthor().getUsername() %></td>
                            <td>
                                <form action="ApproveArticleServlet.do" method="post" class="d-flex gap-1">
                                    <input type="hidden" name="articleId" value="<%=a.getId()%>" />
                                    <button type="submit" name="action" value="approve" class="btn btn-success btn-sm">Approve</button>
                                    <button type="submit" name="action" value="reject" class="btn btn-danger btn-sm">Reject</button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <%
                } else {
            %>
            <p class="text-center alert alert-info">There are no pending articles.</p>
            <%
                }
            %>
        </div>
        
    </body>
</html>

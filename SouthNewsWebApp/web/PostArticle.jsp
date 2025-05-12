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
    List<Category> categories = (List<Category>) session.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Article</title>
    </head>
    <body>
        <jsp:include page="JournalistNavBar.jsp" />
        
        <div class="container mt-5" style="padding-top: 3rem;">
            <h2 class="text-center mb-4">Post a New Article</h2>

            <form action="PostArticleServlet.do" method="post" enctype="multipart/form-data" class="mx-auto" style="max-width: 600px;">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" id="title" name="title" class="form-control" required/>
                </div>

                <div class="mb-3">
                    <label for="category" class="form-label">Category</label>
                    <select id="category" name="categoryId" class="form-select">
                        <%
                            for (Category cat: categories) {
                        %>
                        <option value="<%=cat.getId()%>"><%=cat.getName()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                    
                <div class="mb-3">
                    <label for="image" class="form-label">Related Picture</label>
                    <input type="file" id="image" name="image" accept="image/*" class="form-control" required />
                </div>

                <div class="mb-3">
                    <label for="content" class="form-label">Content</label>
                    <textarea id="content" name="content" rows="10" class="form-control" required></textarea>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Submit Article</button>
                </div>
            </form>
        </div>
    </body>
</html>


<%-- 
    Document   : AddCategory
    Created on : 12 May 2025, 7:41:03 PM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.southnews.entities.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !user.getRole().toString().equals("ADMIN")) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Category</title>
    </head>
    <body>
        <jsp:include page="AdminNavBar.jsp" />
        
        <div class="container mt-5" style="padding-top: 3rem;">
            <h2 class="text-center mb-4">Create New Category</h2>
            
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card shadow">
                        <div class="card-body">
                            <form action="AddCategoryServlet.do" method="post">
                                <div class="mb-3">
                                    <label for="categoryName" class="form-label">Category Name</label>
                                    <input type="text" class="form-control" id="categoryName" name="name" required minlength="2" maxlength="50">
                                </div>
                                <button type="submit" class="btn btn-primary w-100">Add Category</button>
                            </form>
                            <div class="mt-3 text-center">
                                <a href="AdminDashboard.jsp" class="btn btn-link">← Back to Dashboard</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

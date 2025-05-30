<%@page import="com.southnews.entities.Role"%>
<%@page import="com.southnews.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
        
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        
        <nav class="navbar navbar-light bg-primary fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand text-white" href="index.html">SouthNews</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">SouthNews</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="index.html">Home</a>
                            </li>
                            
                            <%
                                if(user == null) {
                            %>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="register.jsp">Register</a>
                            </li>
                            <%
                                } else {
                            %>
                            <li class="nav-item">
                                <a class="nav-link" href="logout.jsp">Logout</a>
                            </li>
                                <%
                                    if(user.getRole() == Role.ADMIN) {
                                %>
                                <li class="nav-item">
                                    <a class="nav-link" href="AdminDashboard.jsp">Dashboard</a>
                                </li>
                                <%
                                    } else if(user.getRole() == Role.JOURNALIST) {
                                %>
                                <li class="nav-item">
                                    <a class="nav-link" href="PostArticle.jsp">Dashboard</a>
                                </li>
                                <%
                                    }
                                %>
                            <%
                                }
                            %>
                            
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>

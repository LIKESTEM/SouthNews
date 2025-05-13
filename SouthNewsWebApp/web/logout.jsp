<%-- 
    Document   : logout
    Created on : 11 May 2025, 1:04:07 PM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <jsp:include page="NavBar.jsp" />
        
        <div class="container mt-5" style="padding-top: 3rem;">
            <div class="card">
                <div class="card-body">
                    <h2 class="card-title text-center">Logout</h2>
                    <p class="card-text text-center">
                        Are you sure you want to logout?
                    </p>
                    <div class="text-center">
                        <a 
                            href="EndSessionServlet.do" 
                            class="btn btn-danger"
                        >
                            Logout
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : login
    Created on : 07 May 2025, 11:15:59 AM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body class="bg-light">
        <jsp:include page="NavBar.jsp" />
        
        <div class="container d-flex justify-content-center align-items-center vh-100 pt-5">
            <div class="card p-4 shadow-sm" style="width: 100%; max-width: 400px;">
                <h2 class="text-center mb-4">Login</h2>
                
                <form action="LoginServlet.do" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" required />
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required />
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>

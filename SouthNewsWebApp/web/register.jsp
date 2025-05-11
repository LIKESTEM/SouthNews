<%-- 
    Document   : register
    Created on : 11 May 2025, 10:49:19 AM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <!-- Bootstrap 5 CDN -->
        <!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body class="bg-light">
        <jsp:include page="NavBar.jsp" />
        
        <div class="container mt-5 pt-5">
            <div class="row justify-content-center">
                <div class="col-12 col-md-8 col-lg-6">
                    <div class="card shadow-sm">
                        <div class="card-header bg-primary text-white">
                            <h4 class="mb-0">User Registration</h4>
                        </div>
                        <div class="card-body">
                            <form action="RegisterServlet.do" method="post">
                                <div class="mb-3">
                                    <label for="username" class="form-label">Username</label>
                                    <input type="text" class="form-control" id="username" name="username" required>
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" required>
                                </div>
                                <div class="mb-3">
                                    <label for="cellNo" class="form-label">Cell No</label>
                                    <input type="text" class="form-control" id="cellNo" name="cellNo">
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div>
                                <div class="mb-3">
                                    <label for="role" class="form-label">Role</label>
                                    <select class="form-select" id="role" name="role">
                                        <option value="READER">Reader</option>
                                        <option value="JOURNALIST">Journalist</option>
                                    </select>
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-success">Register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>

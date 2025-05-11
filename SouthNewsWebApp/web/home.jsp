<%-- 
    Document   : home
    Created on : 11 May 2025, 11:17:23 AM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <jsp:include page="NavBar.jsp" />
        
        <!-- Include Hero Section -->
        <jsp:include page="heroSection.jsp"/>

        <!-- Include News & Updates Section -->
        <jsp:include page="newsUpdatesSection.jsp"/>

        <!-- Include Features Section -->
        <jsp:include page="featuresSection.jsp"/>

        <!-- Include Contact Section -->
        <jsp:include page="contactSection.jsp"/>

        <!-- Include Map Section -->
        <jsp:include page="mapSection.jsp"/>
    </body>
</html>

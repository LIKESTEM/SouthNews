<%-- 
    Document   : newsUpdatesSection
    Created on : 11 May 2025, 11:33:09 AM
    Author     : thabi
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="com.southnews.entities.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <!-- News Updates Section -->
        <section id="news-updates" class="container py-5">
            <h2 class="text-center mb-5 fw-bold">Latest News & Updates</h2>
            
            <%
                List<Article> articles = (List<Article>) session.getAttribute("articles");
            %>
            
            <div class="row g-4">
                <%
                    if(articles != null && articles.size() != 0) {
                        for(Article article: articles) {
                            String base64String = Base64.getEncoder().encodeToString(article.getImage());
                %>
                <!-- News Card 1 -->
                <div class="col-md-6 col-lg-4">
                    <div class="card h-100 shadow-sm">
                        <img src="data:image/jpg;base64,<%=base64String%>" class="card-img-top" alt="News 1">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title"><%=article.getTitle()%></h5>
                            <p class="card-text"><%=article.getContent()%></p>
                            <a href="ViewArticleServlet?id=<%=article.getId()%>" class="btn btn-primary mt-auto">Read More</a>
                        </div>
                    </div>
                </div>

                <%
                        }
                    } else {
                %>
                <p class="text-center">
                    There are no updates.
                </p>
                <%
                    }
                %>
                <!-- You can add more news cards here using the same format -->
            </div>
        </section>
        
    </body>
</html>

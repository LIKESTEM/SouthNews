<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="com.southnews.entities.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>News Carousel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .overlay-top {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            background-color: rgba(0, 0, 0, 0.7);
            color: white;
            padding: 0.5rem;
        }
        .card-img-top {
            height: 250px;
            object-fit: cover;
        }
    </style>
</head>
<body>

<section id="news-updates" class="container py-5">
    <h2 class="text-center mb-5 fw-bold">Latest News & Updates</h2>

    <%
        List<Article> articles = (List<Article>) session.getAttribute("articles");
        int total = (articles != null) ? articles.size() : 0;
        int itemsPerSlide = 3;
    %>

    <% if (articles != null && total >= itemsPerSlide) { %>
    <div id="newsCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <%
                for (int i = 0; i < total; i++) {
            %>
            <div class="carousel-item <%= (i == 0 ? "active" : "") %>">
                <div class="row g-3">
                    <%
                        for (int j = 0; j < itemsPerSlide; j++) {
                            int index = (i + j) % total;
                            Article article = articles.get(index);
                            String base64Image = Base64.getEncoder().encodeToString(article.getImage());
                    %>
                    <div class="col-md-4">
                        <div class="card h-100 shadow-sm">
                            <div class="position-relative">
                                <img src="data:image/jpg;base64,<%=base64Image%>" class="card-img-top" alt="News">
                                <div class="overlay-top">
                                    <h5 class="card-title mb-0"><%=article.getTitle()%></h5>
                                </div>
                            </div>
                            <div class="card-body d-flex flex-column">
                                <p class="card-text">
                                    <%=article.getContent().length() > 100 ? article.getContent().substring(0, 100) + "..." : article.getContent()%>
                                </p>
                                <a href="ViewArticleServlet.do?id=<%=article.getId()%>" class="btn btn-primary mt-auto">Read More</a>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
            <%
                }
            %>
        </div>

        <button class="carousel-control-prev" type="button" data-bs-target="#newsCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#newsCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <% } else { %>
        <p class="text-center">There are not enough articles to display.</p>
    <% } %>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.southnews.entities.Article, com.southnews.entities.Comment, java.util.List" %>
<%@ page session="true" %>
<%
    Article article = (Article) request.getAttribute("article");
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
    com.southnews.entities.User user = (com.southnews.entities.User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=article.getTitle()%></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <jsp:include page="NavBar.jsp" />

    <div class="container py-5" style="padding-top: 12rem;">
        <!-- Article Section -->
        <div class="card mb-4 shadow-sm">
            <div class="card-body">
                <h2 class="card-title"><%= article.getTitle() %></h2>
                <p class="card-text"><%= article.getContent() %></p>
                <p class="text-muted small">
                    <strong>Category:</strong> <%= article.getCategory().getName() %> |
                    <strong>Author:</strong> <%= article.getAuthor().getUsername() %> |
                    <strong>Date:</strong> <%= article.getCreatedAt() %>
                </p>
            </div>
        </div>

        <!-- Comments Section -->
        <div class="card mb-4 shadow-sm">
            <div class="card-body">
                <h4 class="card-title mb-4">Comments</h4>
                <% if (comments != null && !comments.isEmpty()) { %>
                    <% for (Comment c : comments) { %>
                        <div class="mb-3 border-bottom pb-2">
                            <strong><%= c.getUser().getUsername() %>:</strong>
                            <p class="mb-0"><%= c.getContent() %></p>
                        </div>
                    <% } %>
                <% } else { %>
                    <p class="text-muted">No comments yet. Be the first to comment!</p>
                <% } %>
            </div>
        </div>

        <!-- Comment Form -->
        <% if (user != null) { %>
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Leave a Comment</h5>
                    <form action="CommentServlet.do" method="post">
                        <input type="hidden" name="articleId" value="<%= article.getId() %>"/>
                        <div class="mb-3">
                            <label for="content" class="form-label">Comment</label>
                            <textarea class="form-control" name="content" id="content" rows="4" required></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Post Comment</button>
                    </form>
                </div>
            </div>
        <% } else { %>
            <div class="alert alert-info">
                <a href="login.jsp" class="alert-link">Login</a> to comment.
            </div>
        <% } %>
    </div>

</body>
</html>

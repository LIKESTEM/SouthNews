<%-- 
    Document   : contactSection
    Created on : 11 May 2025, 11:35:09 AM
    Author     : thabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <!-- Contact Section -->
        <section id="contact" class="container py-5">
            <h2 class="text-center mb-5 fw-bold">Contact Us</h2>
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-10 col-lg-8">
                    <form action="sendContactForm" method="POST">
                        <div class="mb-3">
                            <label for="name" class="form-label">Your Name</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Your Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="message" class="form-label">Your Message</label>
                            <textarea class="form-control" id="message" name="message" rows="5" required></textarea>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary px-4">Send Message</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        
    </body>
</html>

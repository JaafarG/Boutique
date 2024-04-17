package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import jakarta.persistence.*;

@WebServlet(name = "ArticleListServlet", urlPatterns = {"/articles"})
public class ArticleListServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a", Article.class);
        List<Article> articles = query.getResultList();
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/articles.jsp").forward(request, response); // Display the articles page
    }
}

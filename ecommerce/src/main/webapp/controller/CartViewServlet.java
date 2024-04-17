package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import jakarta.persistence.*;


public class CartViewServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        // Calculate the total and prepare a list of articles to display
        float total = 0;
        List<Article> articlesInCart = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            Article article = em.find(Article.class, entry.getKey());
            int quantity = entry.getValue();
            total += (article.getPrice() * quantity);
            articlesInCart.add(article);
        }

        request.setAttribute("total", total);
        request.setAttribute("articlesInCart", articlesInCart);
        request.getRequestDispatcher("/cart.jsp").forward(request, response); // Show cart page
    }
}

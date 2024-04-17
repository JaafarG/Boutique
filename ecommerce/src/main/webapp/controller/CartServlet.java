
package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import jakarta.persistence.*;


public class CartServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer articleId = Integer.parseInt(request.getParameter("articleId"));

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        Article article = em.find(Article.class, articleId);

        if ("add".equals(action)) {
            cart.put(articleId, cart.getOrDefault(articleId, 0) + 1);

        } else if ("remove".equals(action)) {
            cart.put(articleId, cart.getOrDefault(articleId, 0) - 1);
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("articles");
    }
}

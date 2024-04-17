package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import jakarta.persistence.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            User user = (User) em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
                                 .setParameter("login", login)
                                 .setParameter("password", password)
                                 .getSingleResult();

            if (user != null) {
                request.getSession().setAttribute("user", user); // Log in the user
                response.sendRedirect("articles"); // Redirect to articles page
            }
        } catch (NoResultException e) {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response); // Stay on login page and show error
        }
    }
}
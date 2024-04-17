<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
</head>
<body>
    <h2>Your Cart</h2>
    <c:if test="${!empty articlesInCart}">
        <ul>
            <c:forEach items="${articlesInCart}" var="article">
                <li>
                    ${article.name} - Price: ${article.price} - Quantity: ${article.quantity}
                </li>
            </c:forEach>
        </ul>
        <p>Total: <strong>${total}</strong></p>
    </c:if>
    <c:if test="${empty articlesInCart}">
        <p>Your cart is empty.</p>
    </c:if>
    <a href="articles">Continue Shopping</a>
    <a href="logout">Logout</a>
</body>
</html>

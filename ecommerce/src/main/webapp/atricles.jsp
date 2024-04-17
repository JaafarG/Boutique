<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Articles</title>

</head>
<body>
    <h2>Article List</h2>
    <c:if test="${!empty articles}">
        <ul>
            <c:forEach items="${articles}" var="article">
                <li>
                    ${article.name} - Price: ${article.price} - In Stock: ${article.nbRestant}
                    <a href="cart?action=add&articleId=${article.id}">Add to Cart</a>
                    <a href="cart?action=remove&articleId=${article.id}">Remove from Cart</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <a href="viewCart">View Cart</a>
    <a href="logout">Logout</a>
</body>
</html>

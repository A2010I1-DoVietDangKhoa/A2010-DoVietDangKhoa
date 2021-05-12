<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<form method="get">
    <input type="hidden" name="action" value="search">
    <label>Search product's name: </label><input type="text" name="key">
    <button type="submit" href="/products?action=search">Search</button>
</form>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.getProductId()}">${product.getProductName()}</a></td>
            <td>${product.getProductPrice()}</td>
            <td><a href="/products?action=edit&id=${product.getProductId()}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getProductId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
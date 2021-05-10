<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product details</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Product name: </td>
        <td>${requestScope["product"].getProductName()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${requestScope["product"].getProductDesc()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getProductPrice()}</td>
    </tr>
</table>
</body>
</html>

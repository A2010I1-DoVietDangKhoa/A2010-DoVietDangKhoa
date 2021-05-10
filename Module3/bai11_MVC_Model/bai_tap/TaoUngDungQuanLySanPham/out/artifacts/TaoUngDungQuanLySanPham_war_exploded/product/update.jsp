<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
<h1>Update product info</h1>
<a href="/products">Back to customer list</a>
<form method="post">
    <label>Product name: </label><input type="text" name="name" value="${requestScope["product"].getProductName()}"><br><br>
    <label>Product description: </label><input type="text" name="description" value="${requestScope["product"].getProductDesc()}"><br><br>
    <label>Product price: </label><input type="text" name="price" value="${requestScope["product"].getProductPrice()}"><br><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>

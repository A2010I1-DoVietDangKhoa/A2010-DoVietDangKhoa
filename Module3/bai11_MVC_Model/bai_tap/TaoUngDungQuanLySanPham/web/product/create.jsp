<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
    <h1>New product</h1>
    <a href="/products">Back to product list</a>
    <form method="post">
        <label>Product name: </label><input type="text" name="name"><br><br>
        <label>Product description: </label><input type="text" name="description"><br><br>
        <label>Product price: </label><input type="text" name="price"><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>

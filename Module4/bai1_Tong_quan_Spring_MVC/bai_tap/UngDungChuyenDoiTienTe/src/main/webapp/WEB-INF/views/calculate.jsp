<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<form method="get" action="/calculates">
    <label>USD: </label><input type="text" name="input"><br>
    <button type="submit">Calculate</button>
</form><br>
<c:if test='${requestScope["result"] != null}'>
    <span style="color: red" class="message">${requestScope["result"]}</span>
</c:if>
</body>
</html>

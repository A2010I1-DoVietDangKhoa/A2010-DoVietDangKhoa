<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h1 style="color: cornflowerblue">Result</h1>
    <c:out value="${numOne}"></c:out>
    <c:out value="${operator}"></c:out>
    <c:out value="${numTwo}"></c:out>
    <c:out value="="></c:out>
    <c:out value="${result}"></c:out>
    <br><br>
    <form action="/">
        <button type="submit">Go back</button>
    </form>
</body>
</html>

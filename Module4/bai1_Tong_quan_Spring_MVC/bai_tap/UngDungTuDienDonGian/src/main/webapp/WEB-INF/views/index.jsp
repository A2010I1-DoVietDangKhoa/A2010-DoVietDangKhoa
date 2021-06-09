<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1><br>
<form action="/translate" method="get">
  <label>English word: </label>
  <input type="text" name="eng" value="${eng}"><br><br>
  <button type="submit">Translate</button>
</form><br>
<c:if test='${requestScope["vie"] != null}'>
  <span style="color: blue" class="message">${requestScope["vie"]}</span>
</c:if>
</body>
</html>
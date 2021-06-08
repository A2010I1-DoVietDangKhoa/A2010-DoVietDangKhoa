<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Currency Converter</title>
</head>
<body>
<h1>Currency Converter</h1><br>
<form action="/exchange">
      <label>Exchange Rate: </label>
      <input type="text" name="rate" id="exchange-rate" value="${rate}"><br>
      <label>USD: </label>
      <input type="text" name="usd" id="usd" value="${usd}">
      <button type="submit">Convert</button>
</form><br>
<c:if test='${requestScope["vnd"] != null}'>
  <span style="color: blue" class="message">${requestScope["vnd"]}</span>
</c:if>

<c:if test='${requestScope["result"] != null}'>
  <span style="color: red" class="message">${requestScope["result"]}</span>
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Simple Calculator</title>
  <style type="text/css">
    select {
      width: 200px;
      height: 20px;
    }
  </style>
</head>
<body>
<h2>Calculator</h2>
<form id="recipe" action="/" method="post">
  <label>Number 1: </label><input type="text" name="firstNum"><br><br>
  <label>Number 2: </label><input type="text" name="secondNum"><br><br>
  <button type="submit" name="mathButton" value="+">ADD (+)</button>
  <button type="submit" name="mathButton" value="-">SUB (-)</button>
  <button type="submit" name="mathButton" value="*">MUL (*)</button>
  <button type="submit" name="mathButton" value="/">DIV (/)</button>
</form>
<br>
<c:if test='${requestScope["result"] != null}'>
  <span style="color: red" class="message">${requestScope["result"]}</span>
</c:if>
</body>
</html>
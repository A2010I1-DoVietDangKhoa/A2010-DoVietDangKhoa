<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Sandwich recipe</title>
  <style type="text/css">
    select {
      width: 200px;
      height: 20px;
    }
  </style>
</head>
<body>
<h2>Sandwich</h2>
<form id="recipe" action="/" method="post">
  <input type="checkbox" name="ingredient" value="Lettuce"><label>Lettuce </label>
  <input type="checkbox" name="ingredient" value="Mustard"><label>Mustard </label>
  <input type="checkbox" name="ingredient" value="Tomato"><label>Tomato </label>
  <input type="checkbox" name="ingredient" value="Sprouts"><label>Sprouts </label>
  <button type="submit">Submit</button>
</form>

<c:if test='${requestScope["chosenIngredients"] != null}'>
  <c:forEach var="ingredient" items="${chosenIngredients}">
    <p><c:out value="${ingredient}"></c:out></p>
  </c:forEach>
</c:if>
</body>
</html>
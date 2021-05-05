<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Simple Dictionary</title>
</head>
<body>
<form action="dictionary.jsp" method="post">
  <h1>Enter your word: </h1><br>
  <input type="text" name="search"><button type="submit">Search</button>
</form>
</body>
</html>
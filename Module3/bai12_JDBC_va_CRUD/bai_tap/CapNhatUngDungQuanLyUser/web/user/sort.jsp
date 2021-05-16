<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div align="center">
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <form method="get">
        <input type="hidden" name="action" value="search">
        <label>Search user's country: </label><input type="text" name="key">
        <button type="submit" href="/users?action=search">Search</button>
    </form>
</div>
<div align="center">
    <form method="post">
        <button type="submit" href="/users?action=sort" onclick="refresh()">Sort</button>
    </form>
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${sortUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
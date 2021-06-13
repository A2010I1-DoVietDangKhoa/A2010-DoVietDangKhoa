<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
    <h1>Create</h1>
    <form:form modelAttribute="mailSetting" method="post">
        <label>Id: </label><form:input path="id"/><br><br>
        <label>Language: </label>
        <form:select path="language">
            <form:option value="English" label="English"/>
            <form:option value="Vietnamese" label="Vietnamese"/>
            <form:option value="Japanese" label="Japanese"/>
        </form:select><br><br>
        <label>Emails per page: </label>
        <form:select path="size">
            <form:option value="5" label="5"/>
            <form:option value="10" label="10"/>
            <form:option value="15" label="15"/>
            <form:option value="20" label="20"/>
            <form:option value="25" label="25"/>
            <form:option value="50" label="50"/>
            <form:option value="100" label="100"/>
        </form:select><br><br>
    </form:form>
</body>
</html>

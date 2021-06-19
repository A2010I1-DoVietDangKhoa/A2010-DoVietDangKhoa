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
<%--    <a href="${s:mvcUrl('MailSettingController')}"></a>--%>
<form:form modelAttribute="mailSetting" method="post">
    <form:hidden value="${mailSetting.getId()}" path="id"/><br><br>
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
    <label>Spams filter: </label>
    <form:hidden path="filter" value="false"/>
    <form:checkbox path="filter" value="true" label="Enable spams filter"/><br><br>
    <label>Signature: </label>
    <form:input  value="${mailSetting.getSignature()}" path="signature"/><br><br>
    <button type="submit">Update</button><button><a href="/">Cancel</a></button>
</form:form>
</body>
</html>

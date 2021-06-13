<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Settings</title>
</head>
<body>

    <h1>Mail Settings List</h1>
    <form:form method="get">
        <table>
            <tr>
                <th>ID</th>
                <th>Language</th>
                <th>Pages</th>
                <th>Filter</th>
                <th>Signature</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="mailSetting" items="${listSetting}">
                <tr>
                    <td><c:out value="${mailSetting.getId()}"></c:out></td>
                    <td><c:out value="${mailSetting.getLanguage()}"></c:out></td>
                    <td><c:out value="${mailSetting.getSize()}"></c:out></td>
                    <td><c:choose>
                        <c:when test = "${mailSetting.getFilter() == true}">
                            ON
                        </c:when>
                        <c:otherwise>
                            OFF
                        </c:otherwise>
                    </c:choose></td>
                    <td><c:out value="${mailSetting.getSigature()}"></c:out></td>
                    <td><button><a href="/edit">Edit</a></button></td>
                </tr>
            </c:forEach>
        </table>
    </form:form><br>
    <button><a href="/create">Create</a></button>
</body>
</html>

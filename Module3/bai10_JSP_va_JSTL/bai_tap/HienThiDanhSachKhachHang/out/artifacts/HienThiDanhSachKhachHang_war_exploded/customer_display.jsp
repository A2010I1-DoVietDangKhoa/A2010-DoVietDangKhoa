<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer list display</title>
    <style>
        img{
            height: 60px;
            width: 60px;
        }
    </style>
</head>
<body>
    <h1>Danh sách khách hàng</h1>
    <table border="1" style="border-collapse: collapse">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa Chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${requestScope.customerList}" varStatus="loop">
            <tr>
                <td><c:out value="${customer.name}"></c:out></td>
                <td><c:out value="${customer.dateOfBirth}"></c:out></td>
                <td><c:out value="${customer.address}"></c:out></td>
                <td><img src="${pageContext.request.contextPath}${customer.imagePath}"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

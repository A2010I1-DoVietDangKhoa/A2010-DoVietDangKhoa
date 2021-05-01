<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>Giới thiệu sản phẩm: <%=request.getAttribute("productDesc")%></h2>
    <h2>Giá sản phẩm: <%=request.getAttribute("productPrice")%></h2>
    <h2>Giảm <%=request.getAttribute("discountRate")%>%</h2>
    <h2>Số tiền được giảm: <%=request.getAttribute("discountAmount")%></h2>
</body>
</html>

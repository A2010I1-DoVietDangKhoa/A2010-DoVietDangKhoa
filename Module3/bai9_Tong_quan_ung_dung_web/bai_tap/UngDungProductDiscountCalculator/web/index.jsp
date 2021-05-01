<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ứng dụng chuyển đổi tiền tệ</title>
  </head>
  <body>
    <form action="/display-discount" method="post">
      <label>Giới thiệu sản phẩm</label>
      <input type="text" name="productDescript"><br>
      <label>Giá sản phẩm</label>
      <input type="text" name="productPrice"><br>
      <label>% giảm giá</label>
      <input type="text" name="discountPercent"><span>%</span><br>
      <button type="submit">Calculate</button>
    </form>
  </body>
</html>

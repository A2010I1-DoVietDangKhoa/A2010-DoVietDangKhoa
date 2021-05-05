<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form method="post" action="/calculate">
    <label>First number</label><input type="text" name="numOne"><br><br>
    <label>Operator</label><select name="ops">
      <option value="add">+</option>
      <option value="sub">-</option>
      <option value="mul">x</option>
      <option value="div">/</option>
    </select><br><br>
    <label>First number</label><input type="text" name="numTwo"><br><br>
    <button type="submit">Calculate</button>
  </form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 12/08/2022
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    <h1>Ứng dụng chuyển đổi tiền tệ</h1>
    <label>USD:</label>
    <input type="number" name="usd" value="0"><br>
    <h3>1 USD = 23000 VND</h3>
    <button type="submit">Chuyển đổi</button>
</form>
<h3>VND: ${result}</h3>
</body>
</html>

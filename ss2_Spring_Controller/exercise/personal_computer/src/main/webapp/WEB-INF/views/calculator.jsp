<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 16/08/2022
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" action="/calculate">
    <p>Number 1</p>
    <input type="number" name="number1" required>
    <p>Number 2</p>
    <input type="number" name="number2" required>
    <hr>
    <input type="submit" name="operator" value="+">
    <input type="submit" name="operator" value="-">
    <input type="submit" name="operator" value="*">
    <input type="submit" name="operator" value="/">
</form>
<h4>The result is: ${result}</h4>
</body>
</html>

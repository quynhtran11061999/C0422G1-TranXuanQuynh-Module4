<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 16/08/2022
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h4>Sandwich Condiments</h4>
<form action="/condiments" method="post">
    <c:forEach var="condiments" items="${stringList}">
        <input type="checkbox" name="condiments" value="${condiments}" id="${condiments}">
        <label for="${condiments}">${condiments}</label><br>
    </c:forEach>
    <hr>
    <input type="submit" value="Save">
</form>
<h4>Condiments of your choice</h4>
<ol>
    <c:forEach var="condiments" items="${condiments}">
        <li>${condiments}</li>
    </c:forEach>
</ol>
</body>
</html>

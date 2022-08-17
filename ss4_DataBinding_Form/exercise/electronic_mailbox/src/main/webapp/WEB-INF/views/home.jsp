<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 17/08/2022
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>MailBox</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/chooseMailbox" method="post" modelAttribute="mailBox">
    <div>
        <h4 style="display: inline-block; width: 200px">Language</h4>
        <form:select path="languages" items="${languagesList}" multiple="none"></form:select>
    </div>
    <div style="margin-top: 20px">
        <h4 style="display: inline-block; width: 200px">Page Size: </h4>
        Show <form:select path="pageSize" items="${pageSizeList}" multiple="none"></form:select> emails per page
    </div>
    <div style="margin-top: 20px">
        <h4 style="display: inline-block; width: 200px">Spams filter: </h4>
        <form:checkbox path="spamsFilter"></form:checkbox> Enable spams filter
    </div>
    <div style="margin-top: 20px">
        <h4 style="display: inline-block; width: 200px">Signature: </h4>
        <form:textarea path="signature"></form:textarea>
    </div>
    <div style="margin-top: 20px">
        <input style="background-color: dodgerblue; color: white" type="submit" value="Update">
        <input type="submit" value="Cancel">
    </div>
</form:form>
</body>
</html>

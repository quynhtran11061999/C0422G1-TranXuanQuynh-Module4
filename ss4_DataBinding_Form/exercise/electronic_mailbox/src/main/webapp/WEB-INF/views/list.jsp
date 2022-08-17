<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 17/08/2022
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Mailbox</title>
</head>
<body>
<h2>List Mailbox</h2>
<ol>
    <li>Language: ${mailbox.languages}</li>
    <li>Page Size: ${mailbox.pageSize}</li>
    <li>Spams filter: ${mailbox.spamsFilter}</li>
    <li>Signature: ${mailbox.signature}</li>
</ol>
</body>
</html>

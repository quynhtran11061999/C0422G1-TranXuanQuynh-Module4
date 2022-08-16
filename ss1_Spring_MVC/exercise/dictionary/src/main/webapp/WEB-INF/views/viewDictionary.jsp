<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 15/08/2022
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <style>
        input[type=text] {
            width: 300px;
            font-size: 16px;
            border: 2px solid #ccc;
            border-radius: 4px;
            padding: 12px 10px 12px 10px;
        }
        #submit {
            border-radius: 2px;
            padding: 10px 32px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<h2>Từ Điển Anh - Việt</h2>
<form action="/translate" method="post">
    <input type="text" name="language" placeholder="Nhập từ cần tìm"/>
    <input type = "submit" id = "submit" value = "Tìm"/>
</form>
</body>
<h3>Kết quả khi search <span style="color: red">${language}</span> là: <span style="color: red">${result}</span></h3>
</html>

<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 17/08/2022
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <h2>TỜ KHAI Y TẾ</h2>
    <a href="/" class="btn btn-success">Thêm mới tờ khai</a>
    <h4 style="color: green">${mess}</h4>
    <table class="table table-success table-striped">
        <tr>
            <th>STT</th>
            <th>Họ tên</th>
            <th>Năm sinh</th>
            <th>Giới tính</th>
            <th>Quốc tịch</th>
            <th>Số CMND</th>
            <th>Thông tin đi lại</th>
            <th>Số hiệu phương tiện</th>
            <th>Số ghế</th>
            <th>Ngày khởi hành</th>
            <th>Ngày kết thúc</th>
            <th>Lộ trình đi lại</th>
            <th>Tùy chọn</th>
        </tr>
        <c:forEach var="medical" items="${displayList}" varStatus="status">
        <tr>
            <td>${medical.id}</td>
            <td>${medical.name}</td>
            <td>${medical.yearOfBirth}</td>
            <td>${medical.gender}</td>
            <td>${medical.nationality}</td>
            <td>${medical.idCard}</td>
            <td>${medical.vehicle}</td>
            <td>${medical.vehicleNumber}</td>
            <td>${medical.seats}</td>
            <td>${medical.startDay}/${medical.startMonth}/${medical.startYear}</td>
            <td>${medical.endDay}/${medical.endMonth}/${medical.endYear}</td>
            <td>${medical.route}</td>
            <td><a href="/showUpdate?id=${medical.id}" class="btn btn-success">Sửa</a></td>
        </tr>
        </c:forEach>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: quynh
  Date: 17/08/2022
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Medical declaration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <h2 style="text-align: center">TỜ KHAI Y TẾ</h2>
    <h3 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI
        CẦN
        THIẾT ĐỂ PHÒNG CHỐNG DỊCH BÊNH TRUYỀN NHIỄM</h3>
    <H5 style="color:red; text-align: center">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể
        xử
        lý hình sự</H5>
    <div>
        <div>
            <h5>Họ tên(ghi chữ IN HOA)</h5>
            <input type="text" class="form-control">
        </div>
    </div>
    <div>
        <div class="col-lg-12">
            <div class="row mt-3">
                <div class="col-lg-4">
                    <h5>Năm sinh</h5>
                    <form:select path="year" cssClass="form-control" items="${year}" multiple="none">-</form:select>
                </div>
                <div class="col-lg-4">
                    <h5>Giới tính</h5>
                    <form:select path="gender" cssClass="form-control" items="${gender}" multiple="none">-</form:select>
                </div>
                <div class="col-lg-4">
                    <h5>Quốc tịch</h5>
                    <form:select path="nationality" cssClass="form-control" items="${nationality}"
                                 multiple="none">-</form:select>
                </div>
            </div>
        </div>
    </div>
    <div class="mt-3">
        <h5>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</h5>
        <input type="text" class="form-control">
    </div>
    <div class="mt-3">
        <h5>Thông tin đi lại</h5>
        <form:radiobuttons path="vehicle" items="${vehicle}"></form:radiobuttons>
    </div>
    <div>
        <div class="col-lg-12">
            <div class="row mt-3">
                <div class="col-lg-6">
                    <h5>Số hiệu phương tiện</h5>
                    <input type="text" class="form-control" placeholder="VD: VN123">
                </div>
                <div class="col-lg-6">
                    <h5>Số ghế</h5>
                    <input type="text" class="form-control">
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>

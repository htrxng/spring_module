<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Health Declaration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container rounded border border-4 border-primary mt-2">
    <div class="title mb-2">
        <center>
            <h1>Tờ khai y tế</h1>
        </center>
    </div>
    <div class="text">
        <h5 style="padding-right: 20px;padding-left: 20px">
            Đây là tài liệu quan trọng, thông tin của anh chị sẽ giúp cơ quan y tế liên lạc khi cần
            thiết để phòng chống dịch bệnh truyền nhiễm.</h5>
        <p style="color: red;text-align: center">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có
            thể xử lý hình
            sự.</p>
    </div>
    <div>
        <form:form action="declare" method="post" modelAttribute="healthForm" class="row g-3 p-2">
            <div class="col-md-6">
                <label for="name" class="form-label">Họ Tên(ghi chữ IN HOA) <span style="color: red">(*)</span> </label>
                <form:input path="fullName" id="name" class="form-control" value="${healthDeclarationForm.fullName}"/>
            </div>
            <div class="col-md-3">
                <label for="dateOfBirth" class="form-label">Năm sinh <span style="color: red">(*)</span></label>
                <form:input type="date" class="form-control" id="dateOfBirth" path="dateOfBirth"
                            value="${healthDeclarationForm.dateOfBirth}"/>
            </div>
            <div class="col-md-3">
                <label for="radio-button-gender" class="form-label ml-3">Giới tính <span
                        style="color: red">(*)</span></label>
                <div id="radio-button-gender" style="display: flex">
                    <div class="form-check">
                        <form:radiobutton path="gender" value="Male" id="male"/> <label for="male"> Male</label>
                    </div>
                    <div class="form-check">
                        <form:radiobutton path="gender" value="Female" id="female"/> <label for="female">Female</label>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <label for="idCard" class="form-label">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp
                    khác <span style="color: red">(*)</span></label>
                <form:input class="form-control" type="number" id="idCard" path="idCard"
                            value="${healthDeclarationForm.idCard}"/>
            </div>
            <div class="col-md-12">
                <label for="radio-button-gender" class="form-label ml-3">Thông tin đi lại <span
                        style="color: red">(*)</span></label>
                <div id="radio-button-vehicle" style="display: flex">
                    <div class="form-check">
                        <form:radiobutton path="vehicles" onclick="hideInputOtherVehicles()" id="tauBay"
                                          value="Tàu bay"/>
                        <label for="tauBay">Tàu bay</label>
                    </div>
                    <div class="form-check">
                        <form:radiobutton path="vehicles" onclick="hideInputOtherVehicles()" value="Tàu thuyền"
                                          id="tauThuyen"/>
                        <label for="tauThuyen">Tàu thuyền</label>
                    </div>
                    <div class="form-check">
                        <form:radiobutton path="vehicles" onclick="hideInputOtherVehicles()" value="Ô Tô" id="oTo"/>
                        <label for="oTo">Ô Tô</label>
                    </div>
                    <div class="form-check">
                        <form:radiobutton path="vehicles" onclick="showInputOtherVehicles()" value="Khác"
                                          id="other"/>
                        <label for="other">Khác (Ghi rõ)</label>
                        <form:input class="form-control" path="vehicles" id="otherVehicle"/>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <span>Số hiệu phương tiện</span>
                <form:input class="form-control" path="vehiclesCode" value="${healthDeclarationForm.vehiclesCode}"/>
            </div>
            <div class="col-md-2">
                <span>Số ghế</span>
                <form:input class="form-control" path="seatNumberVehicles" type="number"
                            value="${healthDeclarationForm.seatNumberVehicles}"/>
            </div>
            <div class="col-md-3">
                <span>Ngày khởi hành <span style="color: red">(*)</span></span>
                <form:input class="form-control" type="date" path="startDate"
                            value="${healthDeclarationForm.startDate}"/>
            </div>
            <div class="col-md-3">
                <span>Ngày kết thúc <span style="color: red">(*)</span></span>
                <form:input class="form-control" type="date" path="endDate" value="${healthDeclarationForm.endDate}"/>
            </div>
            <div class="col-md-12 mb-3">
                <span>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh thành phố nào? <span
                        style="color: red">(*)</span></span>
                <form:textarea class="form-control" path="cityVisited" value="${healthDeclarationForm.cityVisited}"/>
            </div>
            <div class="form-row text-center">
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Gửi tờ khai</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<script>
    window.onload = function () {
        hideInputOtherVehicles();
    }

    function showInputOtherVehicles() {
        let otherVehicle = document.getElementById("otherVehicle");
        otherVehicle.style.display = "block";
    }

    function hideInputOtherVehicles() {
        let otherVehicle = document.getElementById("otherVehicle");
        otherVehicle.style.display = "none";
    }
</script>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</html>

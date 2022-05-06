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
</head>
<body>
<h1>Tờ khai y tế</h1>
<h3>Đây là tài liệu quan trọng, thông tin của anh chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để phòng chống dịch bệnh truyền nhiễm</h3>
<h4 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h4>

<form:form action="declare" method="post" modelAttribute="healthForm">
    <div>
        <span>Họ Tên(ghi chữ IN HOA)</span>
        <form:input path="fullName" value="${healthDeclarationForm.fullName}"/>
    </div>
    <div>
        <span>Năm sinh</span>
        <form:input type="date" path="dateOfBirth" value="${healthDeclarationForm.dateOfBirth}"/>
    </div>
    <div>
        <span>Giới tính</span>
        <form:input path="gender" value="${healthDeclarationForm.gender}"/>
    </div>
    <div>
        <span>Số hộc chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</span>
        <form:input type="number" path="idCard" value="${healthDeclarationForm.idCard}"/>
    </div>
    <div>
        <span >
          Thông tin đi lại
        </span>
        <form:radiobutton path="vehicles" value="Tàu bay"/> Tàu bay
        <form:radiobutton path="vehicles" value="Tàu thuyền"/> Tàu thuyền
        <form:radiobutton path="vehicles" value="Ô Tô"/> Ô Tô
        <form:radiobutton path="vehicles" value="Khác"/> Khác
    </div>
    <div>
        <span>Số hiệu phương tiện</span>
        <form:input path="vehiclesCode" value="${healthDeclarationForm.vehiclesCode}"/>
    </div>
    <div>
        <span>Số ghế</span>
        <form:input path="seatNumberVehicles" type="number" value="${healthDeclarationForm.seatNumberVehicles}"/>
    </div>
    <div>
        <span>Ngày khởi hành</span>
        <form:input type="date" path="startDate" value="${healthDeclarationForm.startDate}"/>
    </div>
    <div>
        <span>Ngày kết thúc</span>
        <form:input type="date" path="endDate" value="${healthDeclarationForm.endDate}"/>
    </div>
    <div>
        <span>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh thành phố nào?</span>
        <form:input path="cityVisited" value="${healthDeclarationForm.cityVisited}"/>
    </div>
    <div>
        <input type="submit" value="Gửi tờ khai">
    </div>
</form:form>
</body>
</html>

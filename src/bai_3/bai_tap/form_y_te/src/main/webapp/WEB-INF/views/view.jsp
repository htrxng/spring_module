<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/5/2022
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thông tin y tế</title>
</head>
<body>
<form action="update" method="post">
<%--    <input type="hidden" name="idCard" value="${healthDeclarationForm.idCard}" >--%>
    <p> Họ Tên(ghi chữ IN HOA) ${healthDeclarationForm.fullName}</p>
    <p> Năm sinh ${healthDeclarationForm.dateOfBirth}</p>
    <p> Giới tính ${healthDeclarationForm.gender}</p>
    <p>Số hộc chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác  ${healthDeclarationForm.idCard}</p>
    <p>Thông tin đi lại  ${healthDeclarationForm.vehicles}</p>
    <p> Số hiệu phương tiện ${healthDeclarationForm.vehiclesCode}</p>
    <p>Số ghế  ${healthDeclarationForm.seatNumberVehicles}</p>
    <p>Ngày khởi hành  ${healthDeclarationForm.startDate}</p>
    <p> Ngày kết thúc ${healthDeclarationForm.endDate}</p>
    <p> Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh thành phố nào? ${healthDeclarationForm.cityVisited}</p>
    <input type="submit" value="update">
</form>
</body>
</html>

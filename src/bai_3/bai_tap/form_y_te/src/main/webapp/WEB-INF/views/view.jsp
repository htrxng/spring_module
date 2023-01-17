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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form class="row g-3" action="update" method="post">
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>

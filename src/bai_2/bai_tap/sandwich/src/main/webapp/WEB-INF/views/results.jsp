<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="color: brown">Your Sandwich will include </h2>
<div style="margin: auto">
    <img src="https://i.pinimg.com/564x/9c/7a/8d/9c7a8d87a6d3ceb238b9a24be4bf4488.jpg" alt=""
         style="justify-content: center">
</div>
<table>
    <tr>
        <c:forEach var="condiment" items="${condiments}">
            <c:forEach items="${condimentSelected}" var="condimentSelectId">
                <c:if test="${condiment.condimentId == condimentSelectId}">
                    <td><img src="${condiment.img}" alt="" width="200px" height="200px">
                        <span>${condiment.condimentName}</span></td>
                </c:if>
            </c:forEach>
        </c:forEach>
    </tr>
</table>
</body>
</html>

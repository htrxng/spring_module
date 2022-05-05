<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="get">
    <input type="number" name="firstNumber" placeholder="so dau tien">
    <select name="operator">
        <option value="addition">+</option>
        <option value="subtraction">-</option>
        <option value="multiplication">*</option>
        <option value="division">/</option>
    </select>
    <input type="number" name="secondNumber" placeholder="so thu hai">
    <input type="submit" value="Tinh">
</form>
<p> Results:
    <c:if test="${results != null}">
        ${results}
    </c:if>
</p>
</body>
</html>

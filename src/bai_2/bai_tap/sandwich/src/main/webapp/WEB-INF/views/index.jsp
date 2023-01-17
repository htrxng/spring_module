<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<c:if test="${mess != null}">
  <p>${mess}</p>
</c:if>
<form action="save" method="post">
  <c:forEach items="${condiments}" var="condiment">
    <label for="${condiment.condimentName}">
      <img src="${condiment.img}"
           alt="" width="200px" height="200px">
      lettuce </label>
    <input id="${condiment.condimentName}" type="checkbox" name="condimentSelected" value="${condiment.condimentId}">
  </c:forEach>
    <button>Order</button>
</form>
</body>
</html>

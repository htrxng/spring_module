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
<c:forEach var="condiment" items="${condiments}">
   <p style="color: lightseagreen ">${condiment}</p>
</c:forEach>
</body>
</html>

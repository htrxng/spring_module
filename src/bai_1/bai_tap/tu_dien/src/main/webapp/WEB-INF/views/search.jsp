<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/4/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/search" method="get">
    <input type="text" name="word" placeholder="enter word">
    <input type="submit" value="search">
</form>
<c:if test="${word.word != null }">
    <p>${word.word} meaning ${word.meaning}</p>
</c:if>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/4/2022
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/convert" method="get">
   USD: <input type="text" name="money" >
    <input type="hidden" name="rate" value="23000">
    <input type="submit" value="convert to vnd">
</form>

<h1>VND: ${result}</h1>
</body>
</html>

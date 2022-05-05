<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Box</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="update" method="post" modelAttribute="emailBox">
    <div>
        <span>Languages</span>
        <form:select path="languages">
            <form:option value="english">English</form:option>
            <form:option value="vietnamese">Vietnamese</form:option>
            <form:option value="japanese">Japanese</form:option>
            <form:option value="chinese">Chinese</form:option>
        </form:select>
    </div>
    <div>
        <span>Page size</span>
        <form:select path="pageSize">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
        </form:select>
    </div>
    <div>
        <span> Spams filter:</span>
        <form:checkbox path="spamsFilter"/> enable spams filter
    </div>
    <div>
        <form:textarea path="signature"/>
    </div>
    <div>
        <input type="submit" value="update">
        <input type="reset" value="cancel">
    </div>
</form:form>
</body>
</html>

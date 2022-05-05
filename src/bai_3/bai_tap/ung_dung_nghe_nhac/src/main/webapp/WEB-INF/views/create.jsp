<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="upload" modelAttribute="song" method="post">
    <div>
        <span> Song Name :</span>
        <form:input path="songName"/>
    </div>
    <div>
        <span>Artist</span>
        <form:input path="artist"/>
    </div>
    <div>
        <span>Kind Of Music</span>
        <form:select path="kindOfMusicId">
            <form:option value="1">Pop</form:option>
            <form:option value="2">Rock</form:option>
            <form:option value="3">Jazz</form:option>
            <form:option value="4">Indie</form:option>
            <form:option value="5">Nhac Trinh</form:option>
        </form:select>
    </div>
    <div>
        <span>Link</span>
        <form:input path="filePath"/>
    </div>
    <div>
        <input type="submit" value="upload">
    </div>
</form:form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Song List</title>
</head>
<body>
<h1>Song List</h1>
<table border="1" cellpadding="5">
    <tr>
        <th>Name</th>
        <th>Artist</th>
        <th>Kind Of Music</th>
        <th>Link</th>
    </tr>
<c:forEach var="song" items="${songList}">
    <tr>
        <td>${song.songName}</td>
        <td>${song.artist}</td>
        <td><c:forEach var="kindOfMusic" items="${kindOfMusicList}">
            <c:if test="${song.kindOfMusicId == kindOfMusic.kindOfMusicId}">
                ${kindOfMusic.kindOfMusic}
            </c:if>
        </c:forEach></td>
        <td>${song.filePath}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>

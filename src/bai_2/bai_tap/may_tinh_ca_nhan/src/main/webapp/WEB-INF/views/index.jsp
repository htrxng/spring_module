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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<form id="formCalculator" action="/calculate" method="get">
    <input id="firstNumber" type="text" name="firstNumber">
<%--    <input id="operator" type="text" name="operator">--%>
    <select name="operator">
        <option value="addition">+</option>
        <option value="subtraction">-</option>
        <option value="multiplication">*</option>
        <option value="division">/</option>
    </select>
    <input id="secondNumber" type="text" name="secondNumber">
    <button class="btn btn-pri " type="submit">Calculate</button>
</form>

<p>
    <c:if test="${test != null}">
        Results:  ${requestScope.get("results")}
    </c:if>
</p>
<p>
    <c:if test="${test != null}">
        Results:  ${test}
    </c:if>
</p>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous">
</script>
</html>

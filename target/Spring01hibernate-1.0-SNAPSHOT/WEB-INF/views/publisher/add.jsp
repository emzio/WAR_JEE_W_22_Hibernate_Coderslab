<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 16.03.2022
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Publisher</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    Name: <form:input path="name"></form:input>
    <br>

    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>

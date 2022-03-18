<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 16.03.2022
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
    <form:form method="post" modelAttribute="author">
        Name: <form:input path="firstName"></form:input>
        <br>
        last name: <form:input path="lastName"></form:input>
        <br>
        <input type="submit" value="Dodaj">
    </form:form>
</body>
</html>

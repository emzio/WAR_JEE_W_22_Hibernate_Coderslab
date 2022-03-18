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
    <title>Update Publisher</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher" action="/form/publisher/update">
    Name: <form:input path="name"></form:input>
    <br>
    Books: <form:select path="books" items="${books}" itemLabel="title" itemValue="id"/>
    <form:hidden path="id"></form:hidden>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>

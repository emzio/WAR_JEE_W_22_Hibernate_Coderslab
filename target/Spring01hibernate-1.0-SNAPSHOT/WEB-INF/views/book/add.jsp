<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add book</title>

    <style>
        .flex-container {
            display: flex;
            flex-direction: column;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Add book</h1>
<form:form method="post" modelAttribute="book">
    <div class="flex-container">
        <span>Title:<form:input path="title"/></span>
        <span>Rating: <form:input path="rating"/></span>
        <span>Description: <form:input path="description"/></span>
        <span>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/></span>
        <span>Author: <form:select path="authors" items="${authors}" itemLabel="firstName" itemValue="id"/></span>

    </div>
    <input type="submit" value="Add book">
</form:form>
Authors:
<c:forEach items="${authors}" var="author">
    ${author.toString()}
</c:forEach>
</body>
</html>
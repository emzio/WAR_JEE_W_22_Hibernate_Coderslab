<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Update Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author" action="/form/author/update">
    <div class="flex-container">
        <span>Firstname:<form:input path="firstName"/></span>
        <span>LastName: <form:input path="lastName"/></span>
        <span><form:hidden path="id"/></span>
    </div>
    <input type="submit" value="Update author">
</form:form>


</body>
</html>


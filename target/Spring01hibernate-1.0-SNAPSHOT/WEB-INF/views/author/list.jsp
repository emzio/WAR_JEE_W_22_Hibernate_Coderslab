<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<h2>
    <a href="/form/author/add"> add new Author </a>
</h2>
<table>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td><a href='<c:url value="/form/author/delete/${author.id}"/>'> delete ${author.id}</a> </td>
            <td> <a href="/form/author/update/${author.id}"> update ${author.id}</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
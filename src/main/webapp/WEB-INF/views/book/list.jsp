<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All books</title>
</head>
<body>

<table>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td><a href='<c:url value="/form/delete/${book.id}"/>'> delete ${book.id}</a> </td>
            <td> <a href="/form/update/${book.id}"> update ${book.id}</a> </td>
        </tr>

<%--        <a href='<c:url value="/Servlet2" />'>Link</a>--%>
<%--        <a href=/first.jsp?km=${book.isbn} > link </a>--%>

    </c:forEach>
</table>

</body>
</html>
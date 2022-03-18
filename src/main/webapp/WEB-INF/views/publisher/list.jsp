<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All publishers</title>
</head>
<body>
<table>
    <h2><a href="/form/publisher/add"> Add new publisher </a> </h2>

    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>

            <td><a href='<c:url value="/form/publisher/delete/${publisher.id}"/>'> delete ${publisher.id}</a> </td>
            <td> <a href="/form/publisher/update/${publisher.id}"> update ${publisher.id}</a> </td>
        </tr>

        <%--        <a href='<c:url value="/Servlet2" />'>Link</a>--%>
        <%--        <a href=/first.jsp?km=${book.isbn} > link </a>--%>

    </c:forEach>
</table>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete book</title>

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
<h1>Confirm delete Book :</h1>
<h2>

    <br>
    <span>Title: ${book.title}</span>
    <br>
    <span>Rating: ${book.rating}</span>
    <br>
    <span>Description: ${book.description}</span>
    <br>
    <span>Publisher: ${book.publisher}</span>
    <br>
    <span>Author: ${book.authors}</span>
    <br>

<%--    <form:form method="post" modelAttribute="book">--%>
    <form:form method="post" action="/form/delete" modelAttribute="book">
    <span> <form:hidden path="id"></form:hidden></span>
            <input type="submit" value="Confirm delete">
    </form:form>

    <a href="/form/books" type="button"> back to book list</a>
</h2>


</body>
</html>
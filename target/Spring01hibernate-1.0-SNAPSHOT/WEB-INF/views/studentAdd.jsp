<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 14.03.2022
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentAddForm</title>
</head>
<body>
    <form:form method="post" modelAttribute="student">
        First name: <form:input path="firstName"></form:input>
        <br>
        Last name: <form:input path="lastName"></form:input>
        <br>
        Gender:
        <br>
        Male: <form:radiobutton path="gender" value="M"></form:radiobutton>
        Female: <form:radiobutton path="gender" value="F"></form:radiobutton>
        <br>
        Country: <form:select path="country" items="${countries}"></form:select>
        <br>
        Notes: <form:textarea path="notes"></form:textarea>
        <br>
        Agree to add to Mailing list: <form:checkbox path="mailingList"></form:checkbox>
        <br>
        Programing skilss:
        <br>
        <form:checkboxes items="${programmingSkills}" path="programmingSkills"></form:checkboxes>
        <br>
        hobbies: <form:select path="hobbies" items="${hobbies}" multiple="true"></form:select>
        <br>
<%--        Schools: <form:checkboxes path="schools" items="${modelAtrSchools}" itemLabel="name" itemValue="id"></form:checkboxes>--%>
<%--        <br>--%>
        <input type="submit" value="Wyślij">
    </form:form>
</body>
</html>

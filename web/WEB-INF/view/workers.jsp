<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add" method="post">


    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="text" name="firstName">
    <input type="text" name="secondName">
    <input type="text" name="phone">

    <input type="submit" name="sub" value="Add">


</form>

<table>
    <tr>
        <th>№</th>
        <th>First name</th>
        <th>Second name</th>
        <th>Phone</th>
        <th>Delete</th>
        <th>Edit</th>

    </tr>
    <c:forEach items="${list}" var="workers">
        <tr>
            <td>${workers.id}</td>
            <td>${workers.firstName}</td>
            <td>${workers.secondName}</td>
            <td>${workers.phone}</td>
            <td><a href="<c:url value='/delete/${workers.id}' />"> delete </a> </td>
            <td><a href="<c:url value='/edit/${workers.id}' />"> edit </a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

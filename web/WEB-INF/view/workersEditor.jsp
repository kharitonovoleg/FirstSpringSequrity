
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<form action="/add" method="post">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="hidden" name="id" value="${workers.id}">
    <input type="text" name="firstName" value="${workers.firstName}">
    <input type="text" name="secondName" value="${workers.secondName}">
    <input type="text" name="phone" value="${workers.phone}">
    <input type="submit" name="sub" value="SAVE">
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: muhammed.topgul
  Date: 10/04/2021
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login Page</h1>
<form action="/login" method="post">
    Username: <input type="text" name="username">
    <br/>
    Password: <input type="password" name="password">
    <br/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Submit">
    <br/>
    <font color="red">
        <c:if test="${not empty param.loginFailed}">
            <c:out value="Login failed, incorrect Username or Password"/>
        </c:if>
    </font>
</form>
</body>
</html>

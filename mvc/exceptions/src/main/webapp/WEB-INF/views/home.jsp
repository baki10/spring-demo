<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hello world!</h1>
<a href="${pageContext.request.contextPath}/emp/1">EmployeeNotFoundException</a><br>
<a href="${pageContext.request.contextPath}/emp/2">SQLException</a><br>
<a href="${pageContext.request.contextPath}/emp/3">IOException</a><br>
<a href="${pageContext.request.contextPath}/emp/10">Employee</a><br>
<a href="${pageContext.request.contextPath}/emp/4">GenericException</a><br>


<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
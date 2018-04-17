<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html>
<head>
    <title>T:${title}</title>
</head>
<body>
<h1>Message : ${message}</h1>

<a href="${pageContext.request.contextPath}/admin">Admin</a>
</body>
</html>
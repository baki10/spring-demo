<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<head>
    <title>T:${title}</title>
</head>
<body>
<h1>Message : ${message}</h1>

<c:if test="${pageContext.request.userPrincipal.name != null}">

    <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Logout"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</c:if>

</body>
</html>
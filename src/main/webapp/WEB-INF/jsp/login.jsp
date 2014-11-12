<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="<c:url value='/j_spring_security_check'/>" method="POST">
    <input name="nickname" />
    <button type="submit">Join</button>
</form>
</body>
</html>

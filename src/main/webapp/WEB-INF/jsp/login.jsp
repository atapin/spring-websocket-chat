<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="<c:url value="/static/lib/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/lib/bootstrap/dist/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/login.css"/>" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row col-md-4">
        <h3>Please, introduce yourself</h3>
        <form action="<c:url value='/j_spring_security_check'/>" method="POST" class="form-inline">
            <div id="failed" class="alert alert-danger" style="display:none">
                Nickname is already taken
            </div>
            <input class="form-control" name="nickname" />
            <button class="btn btn-primary" type="submit">Join</button>
        </form>
    </div>
</div>

<script src="<c:url value="/static/lib/jquery/dist/jquery.min.js"/>"></script>
<script>
    $(document).ready(function() {
        if(window.location.href.search("failed") > 0) {
            $("#failed").show();
        }
    });
</script>

</body>
</html>

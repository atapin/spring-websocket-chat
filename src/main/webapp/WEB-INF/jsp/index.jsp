<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Chat</title>

    <link href="<c:url value="/static/lib/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/lib/bootstrap/dist/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/static/chat.css"/>" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row right"><a href="<c:url value="/logout"/>">Logout</a></div>
    <div class="row">
        <div class="row col-md-4">
            Messages:
            <div id="messages">

            </div>

            <form class="form-inline">
                <input class="form-control" name="message"/>
                <button class="btn">Send</button>
            </form>
        </div>
        <div class="col-md-4" >
            Users:
            <div id="users">

            </div>
        </div>
    </div>
</div>

</body>
</html>

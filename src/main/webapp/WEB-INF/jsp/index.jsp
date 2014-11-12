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
    <div class="row">
        <p><i>Hello, ${user}!</i> <a href="<c:url value="/logout"/>" data-bind="click: logout"><i class="glyphicon glyphicon-log-out"></i> Logout</a> </p>
    </div>
    <div class="row">
        <div class="row col-md-4">
            Messages:
            <div id="messages" data-bind="foreach: messages()">
                <p><b><span data-bind="text: user.nickname"></span></b>: <span data-bind="text: message"></span> </p>
            </div>

            <form class="form-inline">
                <input class="form-control" name="message" data-bind="value: message"/>
                <button class="btn" data-bind="click: sendMessage">Send</button>
            </form>
        </div>
        <div class="col-md-4" >
            Users:
            <div id="users" data-bind="foreach: users()">
                <p><i class="glyphicon glyphicon-user"></i> <span data-bind="text: nickname"></span> </p>
            </div>
        </div>
    </div>
</div>


<script src="<c:url value="/static/lib/jquery/dist/jquery.min.js"/>"></script>
<script src="<c:url value="/static/lib/knockout/dist/knockout.js"/>"></script>
<script src="<c:url value="/static/lib/sockjs/sockjs.min.js"/>"></script>
<script src="<c:url value="/static/lib/stomp-websocket/lib/stomp.min.js"/>"></script>
<script src="<c:url value="/static/app.js"/>"></script>
<script>
    $(document).ready(function() {
        var SOCKET_URL = "/chat/chat"

        var sockjs = new SockJS(SOCKET_URL),
            stomp = Stomp.over(sockjs),
            app = new App(stomp);
        app.connect();
        ko.applyBindings(app);



    });
</script>
</body>
</html>

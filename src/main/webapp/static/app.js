function App(stomp) {
    var self = this;

    self.username = ko.observable("");
    self.users = ko.observableArray();
    self.messages = ko.observableArray();
    self.message = ko.observable("");

    self.connect = function() {
        stomp.connect({}, function(frame) {
            self.username(frame.headers["user-name"]);
            self.login();
            stomp.subscribe("/topic/message", function(message) {
                self.messages.push(JSON.parse(message.body));
            });

            stomp.subscribe("/topic/users", function(message) {
                self.users(JSON.parse(message.body));
            });
        }, function(error) {
            console.log("Error", error);
        });
    };

    self.sendMessage = function() {
        if(self.message()) {
            stomp.send("/app/chat", {}, self.message());
            self.message("");
        }
    };

    self.logout = function() {
        var status = {
            nickname: self.username(),
            status: "OFFLINE"
        };
        stomp.send("/app/users", {}, JSON.stringify(status));
        stomp.disconnect();
        window.location.href = "/chat/logout";
    };

    self.login = function() {
        var status = {
          nickname: self.username(),
          status: "ONLINE"
        };
        stomp.send("/app/users", {}, JSON.stringify(status));
    }
}

package com.andreyatapin.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * @author Andrey Atapin
 */
@Controller
@RequestMapping("/")
public class ChatController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Principal principal) {

        return "login";
    }



    @SubscribeMapping(value = "/topic/join")
    public List<User> join(Principal principal) throws UserExistsException {
        return userService.join(principal.getName());
    }

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public Message sendMessage(String message, Principal principal) {
        return new Message(new User(principal.getName()), message);
    }

    @MessageExceptionHandler
    @SendToUser("/errors")
    public String error(Exception ex) {
        return ex.getMessage();
    }

}

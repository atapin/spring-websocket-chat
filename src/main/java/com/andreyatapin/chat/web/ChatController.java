package com.andreyatapin.chat.web;

import com.andreyatapin.chat.model.Message;
import com.andreyatapin.chat.model.User;
import com.andreyatapin.chat.model.UserStatus;
import com.andreyatapin.chat.service.UserExistsException;
import com.andreyatapin.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String index(Model model, Principal principal) {
        model.addAttribute("user", principal.getName());
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @MessageMapping(value = "/users")
    @SendTo("/topic/users")
    public List<User> users(UserStatus userStatus) throws UserExistsException {
        final List<User> users = userService.updateStatus(userStatus);
        return users;
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

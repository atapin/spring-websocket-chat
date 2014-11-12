package com.andreyatapin.chat;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @SubscribeMapping(value = "/topic/join")
    public List<User> join(Principal principal) throws UserExistsException {
        return userService.join(principal.getName());
    }


}

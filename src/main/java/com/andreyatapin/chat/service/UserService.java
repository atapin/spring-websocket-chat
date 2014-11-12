package com.andreyatapin.chat.service;

import com.andreyatapin.chat.model.User;
import com.andreyatapin.chat.model.UserStatus;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Andrey Atapin
 */
public interface UserService extends UserDetailsService {
    List<User> usersOnline();
    List<User> join(String nickname) throws UserExistsException;
    List<User> leave(String nickname);

    List<User> updateStatus(UserStatus userStatus);
}

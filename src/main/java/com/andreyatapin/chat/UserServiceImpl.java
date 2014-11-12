package com.andreyatapin.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrey Atapin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> usersOnline() {
        return userRepository.getUsers();
    }

    @Override
    public List<User> join(String nickname) throws UserExistsException {
        return userRepository.addUser(new User(nickname));
    }

    @Override
    public List<User> leave(String nickname) {
        return userRepository.removeUser(nickname);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

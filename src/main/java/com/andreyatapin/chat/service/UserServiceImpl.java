package com.andreyatapin.chat.service;

import com.andreyatapin.chat.model.User;
import com.andreyatapin.chat.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Andrey Atapin
 */
@Service("userService")
@Scope
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            userRepository.addUser(new User(username));
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
            return new org.springframework.security.core.userdetails.User(username, "", authorities);
        } catch (UserExistsException e) {
            throw new UsernameNotFoundException("Name is already taken");
        }
    }

    @Override
    public List<User> updateStatus(UserStatus userStatus) {
        if(userStatus.getStatus() == UserStatus.Status.OFFLINE) {
            return userRepository.removeUser(userStatus.getNickname());
        }
        return usersOnline();
    }
}

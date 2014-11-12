package com.andreyatapin.chat.service;

import com.andreyatapin.chat.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Andrey Atapin
 */
@Repository
@Scope
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public UserRepository() {}

    public List<User> addUser(User user) throws UserExistsException {
        final String nickname = user.getNickname();
        if(users.containsKey(nickname)) {
            throw new UserExistsException();
        }
        users.put(nickname, user);
        return getUsers();
    }

    public List<User> removeUser(String nickname) {
        users.remove(nickname);
        return getUsers();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

}

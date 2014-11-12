package com.andreyatapin.chat;

import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Andrey Atapin
 */
@Repository
public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public synchronized List<User> addUser(User user) throws UserExistsException {
        final String nickname = user.getNickname();
        if(users.containsKey(nickname)) {
            throw new UserExistsException();
        }
        users.put(nickname, user);
        return getUsers();
    }

    public synchronized List<User> removeUser(String nickname) {
        users.remove(nickname);
        return getUsers();
    }

    public synchronized List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public synchronized boolean isOnline(String nickname) {
        return users.containsKey(nickname);
    }
}

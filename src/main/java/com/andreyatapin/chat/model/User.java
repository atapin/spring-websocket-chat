package com.andreyatapin.chat.model;

/**
 * Stores information about user
 * @author Andrey Atapin
 */
public class User {

    private String nickname;

    public User(String nickname) {
        if(nickname == null || nickname.isEmpty()) throw new IllegalArgumentException("Nickname can't be empty");
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!nickname.equals(user.nickname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nickname.hashCode();
    }
}

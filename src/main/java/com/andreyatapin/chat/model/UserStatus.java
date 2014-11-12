package com.andreyatapin.chat.model;

/**
 * @author Andrey Atapin
 */
public class UserStatus {

    public enum Status {
        ONLINE,
        OFFLINE
    }


    private Status status;
    private String nickname;

    public UserStatus() {}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

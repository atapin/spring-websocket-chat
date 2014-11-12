package com.andreyatapin.chat;

/**
 * @author Andrey Atapin
 */
public class UserExistsException extends Exception {
    public UserExistsException() {
    }

    public UserExistsException(String message) {
        super(message);
    }
}

package com.andreyatapin.chat.service;

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

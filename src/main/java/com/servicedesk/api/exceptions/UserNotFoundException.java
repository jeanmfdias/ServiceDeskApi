package com.servicedesk.api.exceptions;

public class UserNotFoundException extends Throwable {
    private final Long id;

    public UserNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "User %d not found".formatted(this.id);
    }
}

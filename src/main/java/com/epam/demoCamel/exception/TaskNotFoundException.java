package com.epam.democamel.exception;

public class TaskNotFoundException extends Exception {

    private String message;

    public TaskNotFoundException (String message) {
            this.message = message;
    }

    @Override
    public String getMessage () {
        return message;
    }
}

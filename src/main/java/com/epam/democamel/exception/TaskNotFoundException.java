package com.epam.democamel.exception;
/*
 *  Пользовательское исключение
 *  На случай, если таск не будет найден.
 */
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

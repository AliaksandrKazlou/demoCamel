package com.epam.demo.tasks;

/*
 * Task №3
 * Задача: простой текст для передачи
 */
public class PlainText extends Task {

    public static final String TEXT = "Message with plain text and no more";

    public static final String TASK_NAME = "test3";

    @Override
    protected void prepare () {
        body = TEXT;
        headers.put(TASK, TASK_NAME);
    }

}

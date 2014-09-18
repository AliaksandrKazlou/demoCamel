package com.epam.demoCamel.tasks;

public class PlainText extends Task {

    public static final String TEXT = "Message with plain text and no more";
    public static final String TASK_NAME = "test3";

    @Override
    protected void prepare () {
        body = TEXT;
        headers.put(TASK, TASK_NAME);
    }

}

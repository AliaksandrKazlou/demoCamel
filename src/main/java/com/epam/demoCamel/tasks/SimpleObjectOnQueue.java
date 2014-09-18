package com.epam.democamel.tasks;

import com.epam.democamel.entity.Person;

public class SimpleObjectOnQueue extends Task {

    public static final String TASK_NAME = "test1";
    public static final String NAME = "Andrei";
    public static final Integer AGE = 33;

    @Override
    protected void prepare () {
        body = new Person(NAME, AGE);
        headers.put(TASK, TASK_NAME);
    }
}

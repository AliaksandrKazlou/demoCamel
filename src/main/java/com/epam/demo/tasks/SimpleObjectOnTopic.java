package com.epam.demo.tasks;

import com.epam.demo.entity.Person;

/*
 * Task №2
 * Задача: простой объект для передачи в Topic
 */
public class SimpleObjectOnTopic extends Task {

    public static final String TASK_NAME = "test2";
    public static final String NAME = "John";
    public static final Integer AGE = 45;

    @Override
    protected void prepare () {
        body = new Person(NAME, AGE);
        headers.put(TASK, TASK_NAME);
    }
}

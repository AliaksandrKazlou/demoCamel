package com.epam.democml.tasks;

import java.util.Formatter;

/*
 * Task №5
 * Передача сообщения конкретнмоу Consumer'у
 * По умолчанию  выбран consumer № 2
 */
public class PlainTextOnQueueToSpecificConsumer extends Task {

    public static final String TASK_NAME = "test5";

    public static final Integer CONSUMER_BY_DEF = 2;

    public static final String TEXT_MESSAGE = "Specific message to %d consumer";

    //Собственный header для передачи номера Consumer'a
    public static final String CONSUMER = "Consumer";

    @Override
    protected void prepare () {
        body = new Formatter().format(TEXT_MESSAGE, CONSUMER_BY_DEF).toString();
        headers.put(TASK, TASK_NAME);
        headers.put(CONSUMER, CONSUMER_BY_DEF);
    }
}

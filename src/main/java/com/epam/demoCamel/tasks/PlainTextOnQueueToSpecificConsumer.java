package com.epam.demoCamel.tasks;

import java.util.Formatter;

public class PlainTextOnQueueToSpecificConsumer extends Task {

    public static final String TASK_NAME = "test5";

    public static final Integer CONSUMER_BY_DEF = 1;

    public static final String TEXT_MESSAGE = "Specific message to %d consumer";

    public static final String CONSUMER = "Consumer";

    @Override
    protected void prepare () {
        body = new Formatter().format(TEXT_MESSAGE, CONSUMER_BY_DEF);
        headers.put(TASK, TASK_NAME);
        headers.put(CONSUMER, CONSUMER_BY_DEF);
    }
}

package com.epam.demo.tasks;

/*
 * Task №6
 * Задача: Сообщение для аггрегации
 */
public class PlainTextOnQueueForAggregation extends Task {

    //Aggregator требует, что бы у сообщений был указан CorrelationID
    private static final String POSITION = "JMSCorrelationID";

    private static Long COUNT = 0L;

    private Long id;

    public static final String TEXT_MESSAGE = "This is message for aggregation #";

    public static final String TASK_NAME = "test6";

    // Количество сообщений для передачи
    public static final Integer DEFAULT_REPEAT_COUNT = 15;

    public PlainTextOnQueueForAggregation () {
        repeatCount = DEFAULT_REPEAT_COUNT;
    }

    @Override
    protected void prepare () {
        generateIdentity();
        body = TEXT_MESSAGE + id;
        headers.put(TASK, TASK_NAME);
        headers.put(POSITION, id);
    }


    private synchronized void generateIdentity () {
        COUNT++;
        id = COUNT;
    }
}

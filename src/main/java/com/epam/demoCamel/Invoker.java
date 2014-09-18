package com.epam.demoCamel;

import org.apache.camel.ProducerTemplate;
import com.epam.demoCamel.tasks.Task;

public class Invoker {

    public static final String DESTINATION = "direct:start";

    private ProducerTemplate producer;

    public void setProducer (ProducerTemplate producer) {
        this.producer = producer;
    }

    public void execute (Task task) {
        Integer i = 0;
        do {

            System.out.println("Sending message...");
            producer.sendBodyAndHeaders(DESTINATION, task.getBody(), task.getHeaders());
            System.out.println("Message with body \" " + task.getBody().getClass().toString() + "\" sended");
            i++;
        } while (i < task.getRepeatCount());
    }
}

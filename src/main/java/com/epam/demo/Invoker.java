package com.epam.demo;

import com.epam.demo.tasks.Task;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;

/*
 * Класс, который исполняет таски.
 */
public class Invoker {

    private static final Logger LOGGER = Logger.getLogger(Invoker.class);
    // Адрес для отправки
    private static final String DESTINATION = "direct:start";
    // Шаблон Producer'a. Представляет базовую функциональность по отправке сообщений.
    private ProducerTemplate producer;

    public void setProducer(ProducerTemplate producer) {
        this.producer = producer;
    }

    /**
     * Send message, containing in the <tt>Task</tt> object from producer to consumer.
     *
     * @param task Task to execute
     */
    public void execute(Task task) {
        Integer i = 0;
        do {
            LOGGER.info("Sending message...");
            producer.sendBodyAndHeaders(DESTINATION, task.getBody(), task.getHeaders());
            LOGGER.info("Message with body " + task.getBody().toString() + " sent");
            i++;
        } while (i < task.getRepeatCount());
    }
}

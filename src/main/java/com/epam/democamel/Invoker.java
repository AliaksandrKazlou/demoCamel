package com.epam.democamel;

import com.epam.democamel.tasks.Task;
import org.apache.camel.ProducerTemplate;
/*
 * Класс, который исполняет таски.
 */
public class Invoker {
    // Адрес для отправки
    public static final String DESTINATION = "direct:start";
    // Шаблон Producer'a. Представляет базовую функциональность по отправке сообщений.
    private ProducerTemplate producer;

    public void setProducer (ProducerTemplate producer) {
        this.producer = producer;
    }

    public void execute (Task task) {
        Integer i = 0;
        do {

            System.out.println("Sending message...");
            producer.sendBodyAndHeaders(DESTINATION, task.getBody(), task.getHeaders());
            System.out.println("Message with body \" " + task.getBody().toString() + "\" sended");
            i++;
        } while (i < task.getRepeatCount());
    }
}

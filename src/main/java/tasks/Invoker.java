package tasks;

import org.apache.camel.ProducerTemplate;

public class Invoker {

    public static final String DESTINATION = "direct:start";

    private ProducerTemplate producer;

    public void setProducer (ProducerTemplate producer) {
        this.producer = producer;
    }

    public void execute(Task task) {
        producer.sendBodyAndHeaders(DESTINATION, task.body, task.headers);
    }

}

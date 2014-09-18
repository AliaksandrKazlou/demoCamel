import entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Yauheni_Sidarenka on 9/11/2014.
 */
public class Consumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private final static String SRC_Q = "queue";
    private final static String SRC_T = "topic";

    private String name = "";

    public void setName(final String name) {
        this.name = name;
    }

    public void consumeFromQueue(Object o) throws InterruptedException {
        LOGGER.info(introduce() + prepareMsg(o, SRC_Q + "(Object)") + o);
    }

    public void consumeFromQueue(String string) {
        LOGGER.info(introduce() + prepareMsg(string, SRC_Q + "(String)") + string);
    }

    public void consumeFromQueue(Person person) {
        LOGGER.info(introduce() + prepareMsg(person, SRC_Q + "(Person)") + person);
    }

    public void consumeFromQueue(List list) {
        String s = introduce();
        s += prepareMsg(list, SRC_Q + "(List)") + "[";
        for (Object o : list) {
            s += "\n" + o;
        }
        s += list.size() > 0 ? "\n]" : "]";
        LOGGER.info(s);
    }

    public void consumeFromTopic(String string) {
        LOGGER.info(introduce() + prepareMsg(string, SRC_T + "(String)") + string);
    }

    public void consumeFromTopic(Object o) {
        LOGGER.info(introduce() + prepareMsg(o, SRC_T + "(Object)") + o);
    }

    /**
     * Returns own name
     *
     * @return if name is not empty, returns string "I am &lt;name&gt;", otherwise returns empty string
     */
    public String introduce() {
        return "".equals(name) ? "" : "I am " + name + "\n";
    }

    private String prepareMsg(Object o, String src) {
        return "Thread.hashCode()=" + Integer.toHexString(Thread.currentThread().hashCode()) + " " +
                this.toString() + " received " + o.getClass().getSimpleName() +
                " from " + src + ": " + o.getClass().getName() + "=";
    }
}

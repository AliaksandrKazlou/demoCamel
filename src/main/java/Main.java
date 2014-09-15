import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import tasks.SimpleObjectOnQueue;

public class Main {

    public static void main (String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Invoker invoker = (Invoker) context.getBean("invoker");
        invoker.execute(new SimpleObjectOnQueue());
        synchronized (Main.class) {
            Main.class.wait();
        }
    }
}

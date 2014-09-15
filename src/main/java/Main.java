import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import tasks.Invoker;
import tasks.PlainTextTask;

public class Main {

    public static void main (String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Invoker invoker = (Invoker) context.getBean("invoker");
        invoker.execute(new PlainTextTask());
        synchronized (Main.class) {
            Main.class.wait();
        }
    }
}

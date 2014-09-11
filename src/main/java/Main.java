import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main (String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext("context.xml");
        Thread.sleep(1000);
    }
}

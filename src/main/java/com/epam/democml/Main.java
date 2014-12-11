package com.epam.democml;

import com.epam.democml.exception.TaskNotFoundException;
import com.epam.democml.tasks.*;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class Main {

    public static void main (String[] args) throws Exception {

        switch (args.length != 0 ? args[0] : "") {
            case "-h":
                showHelp();
                break;
            case "-t": {
                try {
                    if (args.length == 1) {
                        System.out.println("Cannot find task name");
                        break;
                    }
                    Task task = determineTask(args[1]);
                    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/camel-context.xml");
                    Invoker invoker = (Invoker) context.getBean("invoker");
                    invoker.execute(task);
                    synchronized (Main.class) {
                        Main.class.wait();
                    }
                } catch (TaskNotFoundException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
            break;
            default:
                System.out.println("Incorrect command! Please type either -h for help or -t [task_name] for execute task");
        }
    }

    private static void showHelp () {
        System.out.println("Available options:");
        System.out.println("-t [task_name] - execute task");
        System.out.println("    test1 - Send simple object.Container type: Queue");
        System.out.println("    test2 - Send simple object.Container type: Topic");
        System.out.println("    test3 - Send text message.Container type: Queue");
        System.out.println("    test4 - Send complex object(collection of objects). Container type: Queue");
        System.out.println("    test5 - Send text message to specific consumer. Container type: Queue");
        System.out.println("    test6 - Text messages accumulate until there are less than 10 ones. Then they are sended to consumer. Container type:Queue");
    }


    private static Task determineTask (String taskName) throws TaskNotFoundException {
        switch (taskName) {
            case ComplexObjectOnQueue.TASK_NAME:
                return new ComplexObjectOnQueue();
            case PlainText.TASK_NAME:
                return new PlainText();
            case PlainTextOnQueueForAggregation.TASK_NAME:
                return new PlainTextOnQueueForAggregation();
            case PlainTextOnQueueToSpecificConsumer.TASK_NAME:
                return new PlainTextOnQueueToSpecificConsumer();
            case SimpleObjectOnQueue.TASK_NAME:
                return new SimpleObjectOnQueue();
            case SimpleObjectOnTopic.TASK_NAME:
                return new SimpleObjectOnTopic();
            default:
                throw new TaskNotFoundException("Task not found!");
        }
    }
}

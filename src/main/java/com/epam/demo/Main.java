package com.epam.demo;

import com.epam.demo.builder.FileRouteBuilder;
import com.epam.demo.exception.TaskNotFoundException;
import com.epam.demo.tasks.*;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final String CONTEXT_LOCATION = "META-INF/camel-context.xml";
    private static final String FILE_ROUTE_TASK = "test7";
    private static final String INCORRECT_COMMAND_MESSAGE =
            "Incorrect command! Please type either -h for help or -t [task_name] for execute task";
    private static final String TASK_NOT_FOUND_MESSAGE = "Task not found!";
    private static final String INVOKER_BEAN_NAME = "invoker";
    private static final String TASK_EXPECTED_MESSAGE = "Cannot find task name";

    public static void main(String[] args) throws Exception {

        switch (args.length != 0 ? args[0] : "") {
            case "-h":
                showHelp();
                break;
            case "-t": {
                try {
                    if (args.length == 1) {
                        LOGGER.info(TASK_EXPECTED_MESSAGE);
                        break;
                    }
                    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_LOCATION);
                    if (args[1].compareTo(FILE_ROUTE_TASK) == 0) {
                        CamelContext camelContext = new DefaultCamelContext();
                        camelContext.addRoutes(new FileRouteBuilder());
                        camelContext.start();
                    } else {
                        Task task = determineTask(args[1]);
                        Invoker invoker = (Invoker) context.getBean(INVOKER_BEAN_NAME);
                        invoker.execute(task);
                    }
                    synchronized (Main.class) {
                        Main.class.wait();
                    }
                } catch (TaskNotFoundException e) {
                    LOGGER.info(e.getMessage());
                    break;
                }
            }
            break;
            default:
                LOGGER.info(INCORRECT_COMMAND_MESSAGE);
        }
    }

    private static void showHelp() {
        LOGGER.info("Available options:\n " +
                "-t [task_name] - execute task\n" +
                "    test1 - Send simple object.Container type: Queue\n" +
                "    test2 - Send simple object.Container type: Topic\n" +
                "    test3 - Send text message.Container type: Queue\n" +
                "    test4 - Send complex object(collection of objects). Container type: Queue\n" +
                "    test5 - Send text message to specific consumer. Container type: Queue\n" +
                "    test6 - Text messages accumulate until there are less than 10 ones. Then they are sended to consumer. Container type:Queue\n" +
                "    test7 - Send file message with filter by extension. Container type: Queue\n" +
                "    test8 - Send collection of objects with modification and sort. Container type: Queue\n" +
                "    test9 - Send collection of objects, split it into messages with complex object. Container type: Queue\n");
    }


    private static Task determineTask(String taskName) throws TaskNotFoundException {
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
            case ComplexObjectTransform.TASK_NAME: {
                return new ComplexObjectTransform();
            }
            case ComplexObjectForSplitter.TASK_NAME: {
                return new ComplexObjectForSplitter();
            }
            default:
                throw new TaskNotFoundException(TASK_NOT_FOUND_MESSAGE);
        }
    }
}


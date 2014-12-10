package com.epam.democamel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final String CONTEXT_LOCATION = "/META-INF/spring/camel-context.xml";

    public static void main(String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext(CONTEXT_LOCATION);
        Thread.sleep(1000);
    }
}

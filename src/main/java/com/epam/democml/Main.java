package com.epam.democml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext("/META-INF/spring/camel-context.xml");
        Thread.sleep(1000);
    }
}

package com.epam.democamel.builder;

import com.epam.democamel.processor.FileFilter;
import com.epam.democamel.tasks.Task;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.language.SimpleExpression;

public class FileRouteBuilder extends RouteBuilder {

    public static final String TASK_NAME = "test7";
    private static final String SOURCE_FOLDER_PATH = "file:D:/temp/input/?noop=true";
    private static final String DESTINATION_FOLDER_PATH = "activemq:queue:FileQueue";
    private static final String EXTENTION_FILTER_METHOD_NAME = "isXmlExtension";
    private static final String FILE_ROUTE = "fileRoute";

    @Override
    public void configure() throws Exception {
        RouteDefinition definition =
                from(SOURCE_FOLDER_PATH).routeId(FILE_ROUTE);
        Expression expression = new SimpleExpression(TASK_NAME);
        definition.setHeader(Task.TASK, expression);
        definition.filter().method(FileFilter.class, EXTENTION_FILTER_METHOD_NAME).to(DESTINATION_FOLDER_PATH);
    }

}

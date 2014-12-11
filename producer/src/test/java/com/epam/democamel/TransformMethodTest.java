package com.epam.democamel;

import com.epam.democamel.entity.Student;
import com.epam.democamel.processor.ListMessageSplitter;
import com.epam.democamel.tasks.ComplexObjectForSplitter;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Aliaksandr_Kazlou1 on 12/8/2014.
 */
public class TransformMethodTest extends CamelTestSupport {

    @Test
    public void testSplitter() throws Exception {
        ComplexObjectForSplitter complexObjectForSplitter = new ComplexObjectForSplitter();
        template.sendBodyAndHeaders("direct:start", complexObjectForSplitter.getBody(),
                complexObjectForSplitter.getHeaders());
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(5);
        assertMockEndpointsSatisfied();

    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                context.setTracing(true);
                from("direct:start").split(method(ListMessageSplitter.class, "splitMessage")).
                        to("mock:result");
            }
        };
    }

    public ArrayList<Student> getTestStudentsList() {
        ArrayList<Student> students = new ArrayList<>();
        Student student1 = new Student("qqq", 21);
        Student student2 = new Student("rrr", 22);
        Student student3 = new Student("eee", 23);
        Student student4 = new Student("aaa", 25);
        Student student5 = new Student("ddd", 19);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        return students;
    }
}

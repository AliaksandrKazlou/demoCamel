package com.epam.democamel.processor;

import com.epam.democamel.entity.Student;
import org.apache.camel.Body;

import java.util.List;

/**
 * Created by Aliaksandr_Kazlou1 on 12/5/2014.
 */
public class ListMessageTranslator {

    private static final String TRANSLATOR_MESSAGE = "Translator";

    /**
     * Modify message, containing body of <tt>List</tt><<tt>Student</tt>> type
     *
     * @param body body of the received message to transform
     * @return modified body of <tt>List</tt><<tt>Student</tt>> type
     */
    public List<Student> transformList(@Body List<Student> body){
        for (Student student : body){
            student.addCourse(TRANSLATOR_MESSAGE);
        }
        return body;
    }
}

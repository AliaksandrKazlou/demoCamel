package com.epam.demo.processor;

import com.epam.demo.entity.Student;
import com.epam.demo.tasks.Task;
import org.apache.camel.Body;
import org.apache.camel.Header;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksandr_Kazlou1 on 12/4/2014.
 */
public class ListMessageSplitter{

    /**
     * Split message, containing body of <tt>List</tt><<tt>Student</tt>> type
     * to message with body of <tt>Student</tt> type.
     *
     * @param header header of the received message
     * @param body body of the received message
     * @return the list of splitted messages with the same
     * header value and body of <tt>Student</tt> type.
     */
    public List<Message> splitMessage(@Header(value = "Task") String header, @Body List<Student> body) {
        List<Message> answer = new ArrayList<>(body.size());
        Student[] parts = new Student[body.size()];
        body.toArray(parts);
        for (Student part : parts) {
            DefaultMessage message = new DefaultMessage();
            message.setHeader(Task.TASK, header);
            message.setBody(part);
            answer.add(message);
        }
        return answer;
    }
}

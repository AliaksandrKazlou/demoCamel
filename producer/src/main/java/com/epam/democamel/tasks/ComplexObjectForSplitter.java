package com.epam.democamel.tasks;

import com.epam.democamel.entity.Student;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aliaksandr_Kazlou1 on 12/5/2014.
 */
public class ComplexObjectForSplitter extends Task {

    public static final Integer COUNT_STUDENT = 5;

    public static final Integer COUNT_STUNDENT_COURSES = 3;

    public static final String TASK_NAME = "test9";
    private static final String NAME_LOG = "Name ";
    private static final String COURSE_LOG = "Course ";

    @Override
    protected void prepare() {
        body = populate(COUNT_STUDENT);
        headers.put(TASK, TASK_NAME);
    }

    /**
     * Create list of <tt>Student</tt> type.
     *
     * @param count count of students in the list
     * @return the list of <tt>Student</tt> with filling courses of List<String> type
     */
    private List<Student> populate(Integer count) {
        List<Student> students = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            String randomName = RandomStringUtils.random(5, true, false);
            students.add(new Student(NAME_LOG + randomName, new Random().nextInt()));
            for (int j = 0; j < COUNT_STUNDENT_COURSES; j++) {
                students.get(i).addCourse(COURSE_LOG + new Random().nextInt());
            }
        }
        return students;
    }
}

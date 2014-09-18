package com.epam.democamel.tasks;

import com.epam.democamel.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComplexObjectOnQueue extends Task {

    public static final Integer COUNT_STUDENT = 10;

    public static final Integer COUNT_STUNDENT_COURSES = 5;

    public static final String TASK_NAME = "test4";

    @Override
    protected void prepare () {
        body = populate(COUNT_STUDENT);
        headers.put(TASK, TASK_NAME);
    }

    private List<Student> populate (Integer count) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            students.add(new Student("Name" + new Random().nextInt(), new Random().nextInt()));
            for (int j = 0; j < COUNT_STUNDENT_COURSES; j++) {
                students.get(i).addCourse("Course " + new Random().nextInt());
            }
        }
        return students;
    }
}

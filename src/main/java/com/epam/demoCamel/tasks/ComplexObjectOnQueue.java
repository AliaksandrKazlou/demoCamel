package com.epam.demoCamel.tasks;

import com.epam.demoCamel.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComplexObjectOnQueue extends Task{

    public static final Integer COUNT_STUDENT = 10;

    public static final Integer COUNT_STUNDENT_COURSES = 5;

    public static final String TASK_NAME = "test4";

    @Override
    protected void prepare () {
        body = populate(COUNT_STUDENT);
        headers.put(TASK,TASK_NAME);
    }

    private List<Student> populate(Integer count) {
        List<Student> students = new ArrayList<>(count);
        for(Student student : students) {
            student = new Student("Name" + new Random().nextInt(), new Random().nextInt());
            for(int i = 0; i < COUNT_STUNDENT_COURSES; i++ ) {
                student.addCourse("Course " + new Random().nextInt());
            }
        }
        return students;
    }
}

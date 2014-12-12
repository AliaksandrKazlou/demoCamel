package com.epam.demo.tasks;

import com.epam.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Task №4
 * Задача: Коллекция сложных объектов для передачи
 * Передаём список из 10 студентов, у каждого по 5 курсов
 */
public class ComplexObjectOnQueue extends Task {

    public static final Integer COUNT_STUDENT = 10;
    public static final Integer COUNT_STUNDENT_COURSES = 5;

    public static final String TASK_NAME = "test4";
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
            students.add(new Student(NAME_LOG + new Random().nextInt(), new Random().nextInt()));
            for (int j = 0; j < COUNT_STUNDENT_COURSES; j++) {
                students.get(i).addCourse(COURSE_LOG + new Random().nextInt());
            }
        }
        return students;
    }
}

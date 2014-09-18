package com.epam.demoCamel.entity;

import java.util.List;

public class Student extends Person {

    private List<String> courses;

    public Student (String name, Integer age) {
        super(name, age);
    }

    public void addCourse (String courseName) {
        courses.add(courseName);
    }

    @Override
    public String toString () {
        return "Student{" +
                "courses=" + courses +
                '}';
    }
}

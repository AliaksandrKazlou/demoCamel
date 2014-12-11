package com.epam.democml.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<String> courses = new ArrayList<String>();

    public Student(String name, Integer age) {
        super(name, age);
        courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        courses.add(courseName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "courses=" + courses +
                '}';
    }
}

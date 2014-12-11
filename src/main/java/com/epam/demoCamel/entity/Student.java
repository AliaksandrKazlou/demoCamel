package com.epam.democamel.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<String> courses = new ArrayList<>();

    public Student(String name, Integer age) {
        super(name, age);
        courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        courses.add(courseName);
    }

    @Override
    public String toString() {
        return "Student: " + getName() + " {" +
                "courses=" + courses +
                '}';
    }
}

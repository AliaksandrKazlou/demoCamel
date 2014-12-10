package com.epam.democamel.processor;

import com.epam.democamel.entity.Student;

import java.util.Comparator;

/**
 * Created by Aliaksandr_Kazlou1 on 12/5/2014.
 */
public class StudentComparator  implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

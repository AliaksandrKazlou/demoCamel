package com.epam.demo.entity;

import java.io.Serializable;
/*
 * class Person
 * В приложении представляет собой простой объект для передачи
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -4327358834773106572L;

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public Person (String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString () {
        return "Person with name " + name + ";Age: " + age + " years old";
    }
}

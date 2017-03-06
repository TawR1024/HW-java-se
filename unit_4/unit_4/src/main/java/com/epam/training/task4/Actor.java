package com.epam.training.task4;

import java.io.Serializable;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class Actor implements Serializable {
    private String name;
    private int age;

    public Actor() {
    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

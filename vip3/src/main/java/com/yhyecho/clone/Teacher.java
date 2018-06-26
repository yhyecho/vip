package com.yhyecho.clone;

import java.io.Serializable;

/**
 * Created by Echo on 5/22/18.
 */
public class Teacher implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}

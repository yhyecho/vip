package com.yhyecho.rmi.demo;

import java.io.IOException;

/**
 * Created by Echo on 6/29/18.
 */
public class User {

    private int age;

    public int getAge() throws IOException {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

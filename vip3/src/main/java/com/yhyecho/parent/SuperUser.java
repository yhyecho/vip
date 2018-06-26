package com.yhyecho.parent;

/**
 * Created by Echo on 5/22/18.
 */
public class SuperUser {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "age=" + age +
                '}';
    }
}

package com.yhyecho.entity;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

/**
 * Created by Echo on 5/22/18.
 */
public class Person implements Serializable {

    // transient 不参与序列化
    @Protobuf(fieldType = FieldType.STRING, order = 1)
    private String name;

    @Protobuf(fieldType = FieldType.INT32, order = 2)
    private int age;

    public static int height = 2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

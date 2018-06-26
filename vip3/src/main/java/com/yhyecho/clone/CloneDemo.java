package com.yhyecho.clone;

import java.io.IOException;

/**
 * Created by Echo on 5/22/18.
 */
public class CloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        teacher.setName("Echo");

        Student student = new Student();

        student.setName("Hello");
        student.setAge(30);
        student.setTeacher(teacher);

        Student student1 = (Student) student.deepClone();
        System.out.println(student);

        student1.getTeacher().setName("James");
        System.out.println(student1);
    }
}

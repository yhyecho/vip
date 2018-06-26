package com.yhyecho.SerializableDemo;

import com.yhyecho.entity.Person;

import java.io.*;

/**
 * Created by Echo on 5/22/18.
 */
public class SerialDemo {

    public static void main(String[] args) {
        // 序列化操作
        SerialPerson();

        Person.height = 5;

        // 反序列化操作
        Person person = DeSerialPerson();

        System.out.println(person.height);
    }

    private static void SerialPerson() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();

            person.setAge(18);
            person.setName("Echo");
            oo.writeObject(person);

            System.out.println("序列化成功");

            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person DeSerialPerson() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person = (Person) ois.readObject();
            System.out.println("=====反序列化成功=====");
            System.out.println(person);
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package com.yhyecho.parent;

import java.io.*;

/**
 * Created by Echo on 5/22/18.
 */
public class SuperDemo {
    public static void main(String[] args) {
        // 序列化操作
        SerialPerson();

        // 反序列化操作
        User person = DeSerialPerson();
    }

    private static void SerialPerson() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("person")));
            User person = new User();
            // 父类未实现序列化接口,最后序列化出age的结果为0
            person.setAge(18);
            oo.writeObject(person);

            System.out.println("序列化成功");

            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User DeSerialPerson() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person")));
            User person = (User) ois.readObject();
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

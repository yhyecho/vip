package com.yhyecho.rmi.demo;

import java.io.IOException;

/**
 * Created by Echo on 6/29/18.
 */
public class UserClient {

    public static void main(String[] args) throws IOException {
        User user = new User_Stub();

        int age = user.getAge();

        System.out.println(age);
    }
}

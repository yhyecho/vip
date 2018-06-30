package com.yhyecho.rmi.demo;

/**
 * Created by Echo on 6/29/18.
 */
public class UserServer extends User {

    public static void main(String[] args) {
        UserServer userServer = new UserServer();

        userServer.setAge(18);

        User_Skeleton skel = new User_Skeleton(userServer);

        skel.start();
    }
}

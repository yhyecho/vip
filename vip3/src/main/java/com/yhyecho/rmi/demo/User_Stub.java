package com.yhyecho.rmi.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Echo on 6/29/18.
 */
public class User_Stub extends User {

    private Socket socket;

    public User_Stub() throws IOException {
        this.socket = new Socket("localhost", 8888);
    }

    public int getAge() throws IOException {

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

        outputStream.writeObject("age");

        outputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        return objectInputStream.readInt();
    }
}

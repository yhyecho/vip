package com.yhyecho.rmi.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Echo on 6/29/18.
 * serversocket
 */
public class User_Skeleton extends Thread {

    private UserServer userServer;

    public User_Skeleton(UserServer userServer) {
        this.userServer = userServer;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
         try {
             serverSocket = new ServerSocket(8888);

             Socket socket = serverSocket.accept();

             while (socket != null) {
                 ObjectInputStream read = new ObjectInputStream(socket.getInputStream());

                 String method = (String) read.readObject();

                 if (method.equals("age")) {
                    int age = userServer.getAge();
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeInt(age);
                    outputStream.flush();
                 }
             }

         } catch (IOException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } finally {
             if (serverSocket != null) {
                 try {
                     serverSocket.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
}

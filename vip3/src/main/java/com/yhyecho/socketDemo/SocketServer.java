package com.yhyecho.socketDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Echo on 5/21/18.
 * 单播模式
 */
public class SocketServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888); // 启动一个服务
            while (true) {
                final Socket socket = serverSocket.accept(); // 等待一个接收请求
                new Thread(() -> {
                    // 读取数据
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // 发送数据
                    PrintWriter writer = null;
                    try {
                        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    while (true) {
                        String clientData = null; // 读取客户端发送过来的消息
                        try {
                            clientData = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (clientData == null) {
                            break;
                        }

                        System.out.println("服务端接收到的数据:" + clientData);

                        writer.println("Hello TCP/IP");
                        writer.flush();
                    }
                }).start();
            }
        } catch (IOException e) {
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

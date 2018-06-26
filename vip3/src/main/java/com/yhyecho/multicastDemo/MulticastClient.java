package com.yhyecho.multicastDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by Echo on 5/21/18.
 */
public class MulticastClient {

    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.5.6.7");

            MulticastSocket socket = new MulticastSocket(8888);

            socket.joinGroup(group); // 加到指定的组里面

            byte[] buf = new byte[10];

            while (true) {
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                socket.receive(msgPacket);

                String msg = new String(msgPacket.getData());
                System.out.println("接收到的数据:" + msg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

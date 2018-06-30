package com.yhyecho.rmi;

import com.yhyecho.rmi.impl.SayHelloImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Echo on 6/28/18.
 */
public class HelloServer {

    public static void main(String[] args) {

        try {
            ISayHello hello = new SayHelloImpl();

            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/sayHello", hello);


            System.out.println("server start success");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}

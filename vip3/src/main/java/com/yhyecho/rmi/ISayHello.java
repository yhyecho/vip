package com.yhyecho.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Echo on 6/28/18.
 */
public interface ISayHello extends Remote {

    String sayHello(String name) throws RemoteException;
}

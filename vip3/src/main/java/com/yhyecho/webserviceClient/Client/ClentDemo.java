package com.yhyecho.webserviceClient.Client;

import com.yhyecho.SayHelloImpl;
import com.yhyecho.SayHelloImplService;

/**
 * Created by Echo on 6/29/18.
 */
public class ClentDemo {

    public static void main(String[] args) {
        SayHelloImplService service = new SayHelloImplService();

        SayHelloImpl sayHello = service.getSayHelloImplPort();

        System.out.println(sayHello.sayHello("Sisile...."));
    }
}

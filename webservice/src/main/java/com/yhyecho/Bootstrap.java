package com.yhyecho;

import javax.xml.ws.Endpoint;

/**
 * Created by Echo on 6/29/18.
 */
public class Bootstrap {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/vip/hello", new SayHelloImpl());

        System.out.println("public success");
    }
}

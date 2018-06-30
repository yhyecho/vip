package com.yhyecho;

import javax.jws.WebService;

/**
 * Created by Echo on 6/29/18.
 */
@WebService // SEI和SEI的实现类
public class SayHelloImpl implements ISayHello {

    @Override
    public String sayHello(String name) {

        System.out.println("call sayHello()");
        return "Hello," + name + "I am Echo";
    }
}

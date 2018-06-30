package com.yhyecho;

import javax.jws.WebMethod;

/**
 * Created by Echo on 6/29/18.
 */
public interface ISayHello {

    @WebMethod // SEI中的方法
    String sayHello(String name);
}

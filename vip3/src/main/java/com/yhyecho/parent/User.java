package com.yhyecho.parent;

import java.io.Serializable;

/**
 * Created by Echo on 5/22/18.
 */
public class User extends SuperUser implements Serializable {
    @Override
    public String toString() {
        return "User{}" + super.toString();
    }
}

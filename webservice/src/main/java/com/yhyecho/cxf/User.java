package com.yhyecho.cxf;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Echo on 6/29/18.
 */
@XmlRootElement
public class User {

    public User() {
    }

    private int id;

    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.yhyecho.cxf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Echo on 6/29/18.
 */
public class Storage {

    // 数据仓库
    public static List<User> users = Arrays.asList(
            new User(1, "echo"),
            new User(2, "sisi"),
            new User(3, "menmen")
    );
}

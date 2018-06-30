package com.yhyecho.cxf;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Echo on 6/29/18.
 */
@Service("userServiceImpl")
public class UserSeriveImpl implements UserSerivce {

    @Override
    public List<User> getUsers() {
        return Storage.users;
    }

    @Override
    public Response delete(int id) {
        Storage.users.remove(id);
        Response response = new Response();
        response.setCode("0");
        response.setMsg("success");
        return response;
    }

    @Override
    public User getUser(int id) {
        return Storage.users.get(id);
    }

    @Override
    public Response insert(User user) {
        return null;
    }

    @Override
    public Response update(User user) {
        return null;
    }
}

package com.yhyecho.cxf;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Echo on 6/29/18.
 */

@WebService
@Path(value = "/users/")
public interface UserSerivce {

    @GET
    @Path("/")  // http://id:port/users
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // 根据请求的accept
    List<User> getUsers();

    @DELETE
    @Path("{id}") // http://id:port/users/1
    @Produces(MediaType.APPLICATION_JSON)
    Response delete(@PathParam("id") int id);

    @GET
    @Path("{id}") // http://id:port/users/1
    @Produces(MediaType.APPLICATION_JSON)
    User getUser(@PathParam("id") int id);

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    Response insert(User user);

    @PUT
    @Path("update")
    @Produces(MediaType.APPLICATION_XML)
    Response update(User user);
}

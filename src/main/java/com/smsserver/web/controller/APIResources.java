/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsserver.web.controller;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Guan Ji
 */
@Path("api")
public class APIResources {

    QueryRepository repo = new QueryRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getAllDetailsAPI() {
        System.out.println("Get all userAPI is called");
        return repo.queryGetAllUsers();
    }

    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getDetailsAPI(@PathParam("id") int id) {
        System.out.println("Get userAPI is called..");

        return repo.queryGetUser(id);
    }

    @POST
    @Path("create")
    public Users createAPI(Users a1) {
        System.out.println("creating user restapi");
        repo.queryCreate(a1);
        return a1;
    }

    @PUT
    @Path("update")
    public Users updateAPI(Users a1) {
        System.out.println("Updating user from restapi");
        if (repo.queryGetUser(a1.getId()).getId() == 0) {
            repo.queryCreate(a1);
        } else {
            repo.queryUpdate(a1);
        }

        return a1;
    }

    @DELETE
    @Path("delete/{id}")
    public Users deleteAPI(@PathParam("id") int id) {
        System.out.println("deleting user from restapi");
        Users a1 = repo.queryGetUser(id);
        if (a1.getId() != 0) {
            repo.queryDelete(id);
        }
        return a1;
    }
}

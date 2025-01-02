package org.acme.rest;

import org.acme.repo.UserRepo;
import org.acme.repo.Entity.User;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserRest {
    @Inject
    UserRepo userRepo;

    @POST
    public Response create(User user) {
        return Response.ok(userRepo.create(user)).build();
    }

    @GET
    public Response list() {
        return Response.ok(userRepo.list()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        return Response.ok(userRepo.delete(id)).build();
    }
}

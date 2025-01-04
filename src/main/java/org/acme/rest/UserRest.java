package org.acme.rest;

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
import org.acme.service.PaseoService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserRest {



    @GET
    public Response list() {
        return Response.ok(User.listAll()).build();
    }
    @POST
    public Response create(@RequestBody User user){
        return Response.ok(User.insert(user)).build();
    }

}

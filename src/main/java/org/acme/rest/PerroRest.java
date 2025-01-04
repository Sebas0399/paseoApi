package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.repo.Entity.Perro;
import org.acme.repo.Entity.User;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/perros")
@Produces("application/json")
@Consumes("application/json")
public class PerroRest {
    @GET
    public Response list() {
        return Response.ok(Perro.listAll()).build();
    }
    @POST
    public Response create(@RequestBody Perro perro){
        return Response.ok(Perro.insert(perro)).build();
    }
}

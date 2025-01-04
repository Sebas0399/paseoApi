package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.repo.Entity.Paseador;
import org.acme.repo.Entity.Paseo;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/paseos")
@Produces("application/json")
@Consumes("application/json")
public class PaseoRest {
    @GET
    public Response list() {
        return Response.ok(Paseo.listAll()).build();
    }
    @POST
    public Response create(@RequestBody Paseo paseo){
        return Response.ok(Paseo.insert(paseo)).build();
    }
}

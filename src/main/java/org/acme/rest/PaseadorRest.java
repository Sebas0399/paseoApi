package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.repo.Entity.Paseador;
import org.acme.repo.Entity.Perro;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
@Path("/paseadores")
@Produces("application/json")
@Consumes("application/json")
public class PaseadorRest{

    @GET
    public Response list() {
        return Response.ok(Paseador.listAll()).build();
    }
    @POST
    public Response create(@RequestBody Paseador paseador){
        return Response.ok(Paseador.insert(paseador)).build();
    }
}


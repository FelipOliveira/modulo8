package com.br.foliveira.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.br.foliveira.model.Energia;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("/energia")
@RegisterRestClient(baseUri = "stork://my-service")
public class EnergiaController {
    
    @POST
    @Transactional
    public void criar(Energia energia){
        energia.persist();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void editar(long id, Energia energia){
        Energia.getEntityManager().merge(energia);
    }
}

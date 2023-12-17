package com.br.foliveira.controller;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.br.foliveira.model.Pokemon;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("/pokemon")
@RegisterRestClient(baseUri = "stork://my-service")
public class PokemonController {

    @POST
    @Transactional
    public void criar(Pokemon pkm){
        pkm.persist();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void editar(long id, Pokemon pkm){
        Pokemon.getEntityManager().merge(pkm);
    }
}

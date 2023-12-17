package com.br.foliveira.controller;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.br.foliveira.model.Carta;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/carta")
@RegisterRestClient(baseUri = "stork://my-service")
public class CartaController {

    @GET
    public List<Carta> listar(){
        return Carta.listAll();
    }
    
    @GET
    @Path("/{id}")
    public Carta encontrarPorID(long id){
        return Carta.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletarPorID(long id){
        Carta.deleteById(id);
    }
}

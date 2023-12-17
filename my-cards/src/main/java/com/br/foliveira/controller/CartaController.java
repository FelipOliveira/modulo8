package com.br.foliveira.controller;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.logging.Logger;

import com.br.foliveira.model.Carta;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/carta")
@RegisterRestClient(baseUri = "stork://my-service")
public class CartaController {
    
    private static final Logger LOG = Logger.getLogger(CartaController.class);

    @GET
    public List<Carta> listar(){
        LOG.info("lista de cartas");
        return Carta.listAll();
    }
    
    @GET
    @Path("/{id}")
    public Carta encontrarPorID(long id){
        LOG.info("carta com id: " + id);
        return Carta.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletarPorID(long id){
        Carta.deleteById(id);
        LOG.info("carta deletada");
    }
}

package com.br.foliveira.controller;

import java.util.List;
import java.util.Map;

import com.br.foliveira.model.Ataque;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ataque")
@RegisterRestClient(baseUri = "stork://my-service")
public class AtaqueController {
    
    @GET
    public List<Ataque> listar(){
        return Ataque.listAll();
    }

    @GET
    @Path("/{id}")
    public Response devolver(long id){
        try{
            return Response.status(Response.Status.OK)
                .entity(Ataque.findByIdOptional(id).orElseThrow(NotFoundException::new))
                .build();
        }
        catch(NotFoundException ex){
            return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("mensagem","Não encontrado"))
                .build();
        }
    }

    @POST
    @Transactional
    public void criar(Ataque atk){
        atk.persist();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void editar(long id, Ataque atk){
        Ataque.getEntityManager().merge(atk);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(long id){
        Ataque.deleteById(id);
    }
}

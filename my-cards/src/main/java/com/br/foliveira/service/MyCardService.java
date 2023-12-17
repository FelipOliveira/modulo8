package com.br.foliveira.service;

import io.quarkus.runtime.StartupEvent;
import io.vertx.mutiny.core.Vertx;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class MyCardService {
    
    @ConfigProperty(name = "mycard-service-port", defaultValue = "9001") 
    int port;

    public void init(@Observes StartupEvent ev, Vertx vertx) {
        vertx.createHttpServer()
                .requestHandler(req -> req.response().endAndForget("mycard service pronto"))
                .listenAndAwait(port);
    }
}

package com.br.foliveira.service;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.mutiny.core.Vertx;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class Registration {
    
    @ConfigProperty(name = "consul.host") 
    String host;

    @ConfigProperty(name = "consul.port") 
    int port;

    @ConfigProperty(name = "attack-service-port", defaultValue = "9000") 
    int attack;

    public void init(@Observes StartupEvent ev, Vertx vertx) {
        ConsulClient client = ConsulClient
            .create(vertx, new ConsulClientOptions()
                .setHost(host)
                .setPort(port)
            );

        client.registerServiceAndAwait(
            new ServiceOptions()
                .setPort(attack)
                .setAddress("localhost")
                .setName("my-service")
                .setId("attack")
        );
    }
}

package com.br.foliveira.service;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestContext;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestFilter;

import jakarta.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ResteasyReactiveClientRequestFilter{

    private static final Logger LOG = Logger.getLogger(LoggingFilter.class);

    @Override
    public void filter(ResteasyReactiveClientRequestContext requestContext) {
        LOG.infof("Resolved address by Stork: %s",requestContext.getUri().toString());
    }
}

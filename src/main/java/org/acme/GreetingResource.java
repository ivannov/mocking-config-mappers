package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class GreetingResource {

    @Inject
    AppConfig config;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var suffix = config.showName() ? " My name is Joe" : "";
        return "Hello RESTEasy!" + suffix;
    }
}
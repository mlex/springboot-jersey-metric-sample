package com.instana.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.stereotype.Component;

@Component
@Path("/echo")
public class EchoEndpoint {
  @GET
  @Path("{text}")
  public String echo(@PathParam("text") String text) {
    return "ECHO: " + text;
  }
}

package com.javahash.jersey;
 

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


 
import javax.ws.rs.core.SecurityContext;
 
import javax.ws.rs.core.Context;

 
@Path("resource")
@Singleton
public class MyResource {
    @Context
    SecurityContext securityContext;
 
    // Pide usuario y contraseña
    @GET
    public String getUserPrincipal() {
        return securityContext.getUserPrincipal().getName();
    }
}
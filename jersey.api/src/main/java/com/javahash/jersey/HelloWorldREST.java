package com.javahash.jersey;
 

 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 

/**
 * Root resource (exposed at "helloworld" path)
 */
@Path("helloworld")
public class HelloWorldREST {

/**
 * Method handling HTTP GET requests. The returned object will be sent to
 * the client as "text/plain" media type.
 *
 * @return String that will be returned as a text/plain response.
 */
	
	// http://localhost:8089/Spring-Jersey-Resources/rest/helloworld/bus
	@Path("/bus")
	@GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String testCapas() {
	 return  "b.getConnection()";
	 }
	
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 public String ping() {
	 return "Hey, This is Jersey JAX-RS !";
 }
 @GET
 @Path("/hellojson")
 @Produces(MediaType.APPLICATION_JSON)
 public Todo simplejson() {
	 Todo todo=new Todo();
	 todo.setSummary("www.javahash.com");
	 todo.setDescription("JSON Example");
	 return todo;
 }

}
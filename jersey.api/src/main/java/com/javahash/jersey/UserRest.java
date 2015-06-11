package com.javahash.jersey;



import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.core.Context;

import user.dao.impl.UserDAO;
import user.model.User;
 
@Path("users")
public class UserRest {

	 @BeanParam
	  private User user;
	 ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");   
	
	 @GET
	 @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	 //@RolesAllowed({"manager", "user"}) 
	 public List<User> userGetAll() {
		 //ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	     UserDAO userDao = (UserDAO) context.getBean("UserDAO");
	     List<User> usuarios= userDao.userGetAll();
		 return usuarios;
	} 

	 @GET
	 @Path("/{id}")
	 @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	 public User userGetById(@PathParam("id") int id) {
		 //ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	     UserDAO userDao = (UserDAO) context.getBean("UserDAO");
	     User usr= userDao.userGetById(id);
		 return usr;
	} 


	 @POST
	 @Path("/post")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	 public Response insert(User user) {
		 	String output = user.toString();
		 	UserDAO userDao = (UserDAO) context.getBean("UserDAO");
		     userDao.insert(user);
		  return Response.status(200).entity(output).build();
	 }
	 
	 
 	 @DELETE
	 @Path("{id}")
 	 @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
 	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response delete(@PathParam("id") int id){
			UserDAO userDao = (UserDAO) context.getBean("UserDAO");
     		userDao.delete(id);
     		String output = user.toString();
     		return Response.status(200).entity(output).build();
	 	}
 	 
  

	 @PUT
	 @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public Response update(User user) {
		 UserDAO userDao = (UserDAO) context.getBean("UserDAO");
  		 userDao.update(user);
  		 String output = user.toString();
  		return Response.status(200).entity(output).build();
	 }
 
 

 	 
 	 
  
	  @GET
      @Produces("text/plain;charset=UTF-8")
      @Path("/hello")
      public String sayHello(@Context SecurityContext sc) {
              if (sc.isUserInRole("admin"))  return "Hello World!";
              throw new SecurityException("User is unauthorized.");
      }
 	 
 	 
	@Path("/dummy")
	@GET
	 @Produces(MediaType.TEXT_PLAIN)
	 public String dummy() {
	 return  "<dummy SERVICE>";
	 }
}


/*
 
	Method	URL	Action
	GET	/api/wines	Retrieve all wines
	GET	/api/wines/search/Chateau	Search for wines with ‘Chateau’ in their name
	GET	/api/wines/10	Retrieve wine with id == 10
	POST/api/wines	Add a new wine
	PUT	/api/wines/10	Update wine with id == 10
	DELETE	/api/wines/10	Delete wine with id == 10

*/

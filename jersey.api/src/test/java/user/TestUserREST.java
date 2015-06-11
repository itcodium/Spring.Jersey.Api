package user;

 
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
  

public class TestUserREST {
	
	// http://localhost:8089/Spring-Jersey-Resources/rest/users/hello
		
	  static ClientConfig config = new ClientConfig();
	  static Client client = ClientBuilder.newClient(config);
	  static WebTarget target = client.target(getBaseURI());
	
	  public static void userGetAll() {
		  System.out.println(target.path("users").request()
				    .accept(MediaType.APPLICATION_JSON).get(String.class)
				    .toString());
	  }
	  
	  public static void userGetById(String id) {
			System.out.println(target.path("users").path(id).request()
				    .accept(MediaType.APPLICATION_JSON).get(String.class)
				    .toString());
	  }
	  
	  public static void userDelete(String id) {
		  target = null;
          target = client.target(getBaseURI());
          
			String input ="{ \"name\":\"POST 55 \", \"email\": \"POST_55@EMAIL.com\"}";
          		
          target = target.path("users").path(id);

          Response response = target.request(MediaType.APPLICATION_JSON).delete();
         
          System.out.println(response);
          if(response.getStatus() == 200) {
                 System.out.println("post success");
          }
	  }
	public static void userInsert() {
	        target = null;
            target = client.target(getBaseURI());
            
			String input ="{ \"name\":\"POST 55 \", \"email\": \"POST_55@EMAIL.com\"}";
            		
            target = target.path("users").path("post");

            Response response = target.request(MediaType.APPLICATION_JSON)
            		.post(Entity.entity(input, MediaType.APPLICATION_JSON),Response.class);
           
            System.out.println(response);
            if(response.getStatus() == 200) {
                   System.out.println("post success");
            }
            
  }
	
	public static void userUpdate() {
		
		target = null;
        target = client.target(getBaseURI());
        
		String input ="{ \"idUser\":\"7\", \"name\":\"email Updated\", \"email\": \"POST_Updated@Updated.com\"}";
        		
        target = target.path("users");

        Response response = target.request(MediaType.APPLICATION_JSON)
        		.put(Entity.entity(input, MediaType.APPLICATION_JSON),Response.class);
       
        System.out.println(response);
        if(response.getStatus() == 200) {
               System.out.println("post success");
        }
        
}
	
	
	
	 
	
	 private static URI getBaseURI() {
		    return UriBuilder.fromUri("http://localhost:8089/Spring-Jersey-Resources/rest").build();
		  }
	
	  
}


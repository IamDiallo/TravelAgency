package travels.management.web.resource;

import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.*;


import travels.management.web.data.*;
import travels.management.web.service.*;

@Path("/travels")
public class TravelResource {
	
	TravelService travelService = new TravelService();
	
	 @Context
	 UriInfo uriInfo;
	 
	 // return all countries
	 @Path("/countries")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public Response getCountries() { 
	    // Convert to GenericEntity and return in response    
		// needs empty body to preserve generic type
	    GenericEntity<List<Country>> entities = new GenericEntity<List<Country>>(travelService.getCountries()){};
    
    	return Response.status(Response.Status.OK)
            .entity(entities)
            .build();
	 }
	 
	 
	// return all destination by city
	 @Path("city/{id}")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public Response  getDestinationsByCity(@PathParam("id") int id){
		 List<Destination> cityDests = travelService.getDestinationsByCity(id);
		 GenericEntity<List<Destination>> entities = new GenericEntity<List<Destination>>(cityDests) {};
	      
		 return Response.status(Response.Status.OK)
	    		  .entity(entities)
	    		  .build();
	 }
	 
	 // return all cities
	 @Path("/cities")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public Response  getCities(){
		 List<City> cities = travelService.getCities();
		//needs empty body to preserve generic type
		 GenericEntity<List<City>> entities = new GenericEntity<List<City>>(cities){};
		 
		 return Response.status(Response.Status.OK)
	    		  .entity(entities)
	    		  .build();
	 }
	 
	 // return all destinations types
	 @Path("/typesDests")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public Response  getDestTypes(){
		 List<DestType> destTypes = travelService.getDestTypes();
		 GenericEntity<List<DestType>> entities = new GenericEntity<List<DestType>>(destTypes){};
		 
		 return Response.status(Response.Status.OK)
	    		  .entity(entities)
	    		  .build();
	 }
	 
	 
	 @Path("destinations/{id_typeDest}")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public Response  getDestByTypeDest(@PathParam("id_typeDest") int id_typeDest){
		 List<DestinationName> destinations = travelService.getDestinationName(id_typeDest);
		 GenericEntity<List<DestinationName>> entities = new GenericEntity<List<DestinationName>>(destinations){};
	      
	      return Response.status(Response.Status.OK)
	    		  .entity(entities)
	    		  .build();
	 }
	 
	 
	 

}

package travels.management.web.resource;

import java.net.URI;
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
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response  addDest(Destination dest)  {
	    Destination destination = travelService.addDest(dest);
	    if(destination == null) {
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    URI uri = uriInfo.getRequestUri();
	    String newUri = uri.getPath() + "/" + destination.getId();
	    return Response.status(Response.Status.CREATED)
	                   .contentLocation(uri.resolve(newUri))
	                   .build();
}
	 
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
	 
	 // return all destinations types
	 @Path("/destGroups")
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public Response  getDestGroup(){
		 List<DestGroup> destGroup = travelService.getDestGroup();
		 GenericEntity<List<DestGroup>> entities = new GenericEntity<List<DestGroup>>(destGroup){};
		 
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
	 
	 
	 @GET
	 @Produces(MediaType.APPLICATION_XML)
	 public Response  getAllDest(){
		 List<DestinationName> destinations = travelService.getAllDest();
		 GenericEntity<List<DestinationName>> entities = new GenericEntity<List<DestinationName>>(destinations){};
	      
	      return Response.status(Response.Status.OK)
	    		  .entity(entities)
	    		  .build();
	 }
	 
	 @GET
	 @Path("/{id}")
	 @Produces(MediaType.APPLICATION_XML)
	 public Response getDestination(@PathParam("id") int id) {
		 DestinationName dest = travelService.getDestination(id);
		if(dest == null) {
		  return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri())
		                .rel("self")
		                .type("application/xml")
		                    .build();
		    return Response.status(Response.Status.OK)
		                   .entity(dest)
		                   .links(link)
		                   .build();
	  }
	 
	 @DELETE
	 @Path("/{id}")
	 @Produces(MediaType.APPLICATION_XML)
	 public Response deleteDest(@PathParam("id") int id) { 
	    if(travelService.deleteDest(id) == false) {
	      return Response.status(Response.Status.NOT_FOUND).build();
	    }
	    return Response.status(Response.Status.OK).build();
	  }
	 
	 
	 @PUT
	 @Path("/{id}")
	 @Consumes(MediaType.APPLICATION_XML)
	 @Produces(MediaType.APPLICATION_XML)
	 public Response updateDestination(@PathParam("id") int id, Destination dest) {
	    Destination destination = travelService.updateDestination(id,dest);
	    if(destination == null) {
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    Link link = Link.fromUri(uriInfo.getRequestUri())
	                    .rel("self")
	                    .type("application/xml")
	                    .build();
	    return Response.status(Response.Status.OK)
	                   .links(link)
	                   .build();
	  }
	
	 
	 
	 

}

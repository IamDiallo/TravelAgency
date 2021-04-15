package travels.management.client;

import java.util.*;

import org.apache.cxf.jaxrs.client.*;
import travels.management.web.data.Countries;

public class Test {
	private static String webServiceUrl = "http://localhost:8080/travels.management.web/api/travels/allCountry";

	public static void main(String[] args) {
		getAll();
	}
	
	private static List<Countries> getAll() {
	    System.out.println("Getting all...");
	    WebClient c = WebClient.create(webServiceUrl);
	    List<Countries> l = (List<Countries>) c.getCollection(Countries.class);
	    for(Countries s : l) {
	      System.out.println(s.toString());
	    }
	    System.out.println("OK.");
		return l;
	    
	}

}

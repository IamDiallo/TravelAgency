package com.travel.webservice.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import javax.jws.WebService;

import com.travel.webservice.model.City;
import com.travel.webservice.model.Country;
import com.travel.webservice.model.DestType;
import com.travel.webservice.model.DataBaseHelper;
import com.travel.webservice.model.DestGroup;
import com.travel.webservice.model.DestinationName;
import com.travel.webservice.model.Destination;

// this annotation Webservice will service will be the service that will appear in wdsl file
@WebService(targetNamespace = "http://service.webservice.travel.com/",
endpointInterface = "com.travel.webservice.service.Travel",
portName = "TravelPort",serviceName = "TravelService")
public class TravelImp implements Travel{

	// get object for data base connector
	DataBaseHelper db = DataBaseHelper.getInstance();
	

	 // get the list of all countries
	public List<Country> getCountry() { 
		List<Country> countries = new ArrayList<Country>(); // instantiate a list to store all the element that will be returned
		try {
        String sql ="select * from countries";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	Country ct = new Country();   // instantiate a country object and add the value of the sql query in it
            ct.setId(rs.getInt("id_country"));
            ct.setName(rs.getString("countryName"));
            countries.add(ct);  // add the object to the list
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return countries; // return the list
	}
	
	
	//All destination per city
    public List<Destination> getDestinationsByCity(int id) {
        List<Destination> cityDest  = new ArrayList<Destination>(); // instantiate a list to store all the element that will be returned
        try {
            String sql ="SELECT * FROM destinations JOIN dest_type on destinations.typeDest = dest_type.id where city_id =? ";
            db.myPrepareStatement(sql);
            Object[] parameters = {id};
            db.addParameters(parameters);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
                Destination dt = new Destination(); // instantiate a country object and add the value of the sql query in it
                dt.setId(rs.getInt("id"));
                dt.setNameDest(rs.getString("nameDest"));
                dt.setTypeDest(rs.getInt("typeDest"));
                dt.setDestName(rs.getString("destType"));
                dt.setImg(rs.getString("img"));
                cityDest.add(dt); // add the object to the list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityDest;  // return the list
    }
    
  //return All cities
    public List<City> getCities() {
        List<City> cityType  = new ArrayList<City>(); // instantiate a list to store all the element that will be returned
        try {
        	String sql ="Select * from cities join countries on cities.country_id = countries.id_country";
            db.myPrepareStatement(sql);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
                City ct = new City();
                ct.setId(rs.getInt("id"));
                ct.setLongitude(rs.getFloat("longitude"));
                ct.setLatitude(rs.getFloat("latitude"));
                ct.setIdCountry(rs.getInt("country_id"));
                ct.setName(rs.getString("name"));
                ct.setCountryName(rs.getString("countryName"));
                ct.setCityImg(rs.getString("cityImg"));
                ct.setPrice(rs.getFloat("esti_price"));
                
                cityType.add(ct); // add the object to the list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityType;  // return the list
    } 

    // list of destinations
	public List<DestType> getDestinations() {
		List<DestType> destTypeList = new ArrayList<DestType>(); // instantiate a list to store all the element that will be returned
		try {
        String sql ="select * from dest_type";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	DestType dest_type = new DestType(); // instantiate a country object and add the value of the sql query in it
        	dest_type.setId(rs.getInt("id"));
        	dest_type.setDestType(rs.getString("destType"));
        	dest_type.setImg_link(rs.getString("img_link"));
        	destTypeList.add(dest_type);  // add the object to the list
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return destTypeList;  // return the list
	}

    // get a list of destination name grouped by destination type
	public List<DestinationName> getDestinationName(int idDestType) {
		// TODO Auto-generated method stub
		 List<DestinationName> dn  = new ArrayList<DestinationName>(); // instantiate a list to store all the element that will be returned
		 try {
	            String sql ="SELECT * FROM destinations join dest_type on destinations.typeDest = ? JOIN cities on destinations.city_id =cities.id group by nameDest";
	            db.myPrepareStatement(sql);
	            Object[] parameters = {idDestType};
	            db.addParameters(parameters);
	            ResultSet rs = db.myExecuteQuery();
	            while(rs.next()) {
	            	DestinationName destName = new DestinationName(); // instantiate a country object and add the value of the sql query in it
	                destName.setId(rs.getInt("id"));
	                destName.setNameDest(rs.getString("nameDest"));
	                destName.setTypeDest(rs.getInt("typeDest"));
	                destName.setCity_id(rs.getInt("city_id"));
	                destName.setCityName(rs.getString("name"));
	                destName.setImg(rs.getString("img"));
	                dn.add(destName);   // add the object to the list
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dn;  // return the list
	}

    // return a list of destination type with the number of destination for each
	public List<DestGroup> getDestGroup() {
		List<DestGroup> destTypeGroup = new ArrayList<DestGroup>(); // instantiate a list to store all the element that will be returned
		try {
        String sql ="SELECT count(destination_id) as num_dest, destination_id, cities.name, cities.longitude, cities.latitude FROM destinations "
        		+ "JOIN dest_type on destinations.typeDest = dest_type.id JOIN cities on destinations.city_id =cities.id group by cities.name";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	DestGroup dest = new DestGroup(); // instantiate a country object and add the value of the sql query in it
        	dest.setDestiId(rs.getInt("destination_id"));
        	dest.setCityName(rs.getString("name"));
        	dest.setDestCount(rs.getInt("num_dest"));
        	dest.setLongitude(rs.getFloat("longitude"));
        	dest.setLatitude(rs.getFloat("latitude"));
        	destTypeGroup.add(dest);   // add the object to the list
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return destTypeGroup;  // return the list
	}
    
	


}


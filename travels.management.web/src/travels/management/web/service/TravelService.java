package travels.management.web.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import travels.management.web.data.*;

public class TravelService {
	
	// get object for data base connector
	DataBaseHelper db = DataBaseHelper.getInstance();
	
	// get the list of all countries
	public List<Country> getCountries() {  
		List<Country> countries = new ArrayList<Country>(); // instantiate a list to store all the element that will be returned
		try {
        String sql ="select * from countries";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	Country ct = new Country(); // instantiate a country object and add the value of the sql query in it
            ct.setId(rs.getInt("id_country"));
            ct.setName(rs.getString("countryName"));
            countries.add(ct); // add the object to the list
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return countries; // return the list
	}
	
	
	// get All destinations per city
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
                dt.setCityDest(rs.getInt("city_id"));
                dt.setImg(rs.getString("img"));
                cityDest.add(dt);  // add the object to the list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityDest; // return the list
    }
    
    //All cities 
    public List<City> getCities() {
        List<City> cityType  = new ArrayList<City>(); // instantiate a list to store all the element that will be returned
        try {
        	String sql ="Select * from cities join countries on cities.country_id = countries.id_country";
            db.myPrepareStatement(sql);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
            	City ct = new City(); // instantiate a country object and add the value of the sql query in it
                ct.setId(rs.getInt("id"));
                ct.setLongitude(rs.getFloat("longitude"));
                ct.setLatitude(rs.getFloat("latitude"));
                ct.setIdCountry(rs.getInt("country_id"));
                ct.setName(rs.getString("name"));
                ct.setCountryName(rs.getString("countryName"));
                ct.setCityImg(rs.getString("cityImg"));
                ct.setPrice(rs.getFloat("esti_price"));
                
                cityType.add(ct);  // add the object to the list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityType; // return the list
    }

    // get list of destinations types
	public List<DestType> getDestTypes() {
		List<DestType> destTypeList = new ArrayList<DestType>(); // instantiate a list to store all the element that will be returned
		try {
        String sql ="select * from dest_type";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	DestType dest_type = new DestType();  // instantiate a country object and add the value of the sql query in it
        	dest_type.setId(rs.getInt("id"));
        	dest_type.setDestType(rs.getString("destType"));
        	dest_type.setImg_link(rs.getString("img_link"));
        	destTypeList.add(dest_type); // add the object to the list
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return destTypeList;  // return the list
	}


	// get all destination per type of destination
	public List<DestinationName> getDestinationName(int idDestType) {
		 List<DestinationName> dn  = new ArrayList<DestinationName>();
		 try {
	            String sql ="SELECT * FROM destinations join dest_type on destinations.typeDest = dest_type.id JOIN cities on destinations.city_id =cities.id WHERE destinations.typeDest = ?";
	            db.myPrepareStatement(sql);
	            Object[] parameters = {idDestType};
	            db.addParameters(parameters);
	            ResultSet rs = db.myExecuteQuery();
	            while(rs.next()) {
	                DestinationName destName = new DestinationName(); // instantiate a country object and add the value of the sql query in it
	                destName.setId(rs.getInt("id"));
	                destName.setNameDest(rs.getString("nameDest"));
	                destName.setTyDest(rs.getInt("typeDest"));
	                destName.setCity_id(rs.getInt("city_id"));
	                destName.setCityName(rs.getString("name"));
	                destName.setImg(rs.getString("img"));
	                dn.add(destName);  // add the object to the list
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dn;  // return the list
	}
	
	// get all destination group them by cities and count the numnber of destinations for each city
	public List<DestGroup> getDestGroup() {
		List<DestGroup> destTypeGroup = new ArrayList<DestGroup>();
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
        	destTypeGroup.add(dest); // add the object to the list
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return destTypeGroup;  // return the list
	}
	
	// add a destination
	public Destination addDest(Destination dest) {
		try {
	        String sql ="INSERT INTO destinations(nameDest, typeDest, city_id, img) VALUES (?, ?, ?, ?)";
	        db.myPrepareStatement(sql);
	        Object[] parameters = {dest.getNameDest(), dest.getTypeDest(), dest.getCityDest(), dest.getImg()};
	        db.addParameters(parameters);
	        db.myExecuteUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.print(e.getMessage());
		    }
		return dest; // return the destination added
	
	}
	
	// get All destination
	public List<DestinationName> getAllDest() {
		List<DestinationName> dn  = new ArrayList<DestinationName>();
		 try {
	            String sql ="SELECT * FROM destinations join dest_type on destinations.typeDest = dest_type.id JOIN cities on destinations.city_id =cities.id";
	            db.myPrepareStatement(sql);
	            ResultSet rs = db.myExecuteQuery();
	            while(rs.next()) {
	                DestinationName destName = new DestinationName(); // instantiate a country object and add the value of the sql query in it
	                destName.setId(rs.getInt("destination_id"));
	                destName.setNameDest(rs.getString("nameDest"));
	                destName.setNameTypeDest(rs.getString("destType"));
	                destName.setTyDest(rs.getInt("typeDest"));
	                destName.setCity_id(rs.getInt("city_id"));
	                destName.setCityName(rs.getString("name"));
	                destName.setImg(rs.getString("img"));
	                dn.add(destName); // add the object to the list
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dn;  // return the list
	}
	
	// Delete a destination
	public boolean deleteDest(int id) {
		try {
	        String sql ="DELETE FROM destinations WHERE destination_id = ?";
	        db.myPrepareStatement(sql);
	        Object[] parameters = {id};
	        db.addParameters(parameters);
	        db.myExecuteUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.print(e.getMessage());
		    }
		return true;
	
	}
	
	
    
}

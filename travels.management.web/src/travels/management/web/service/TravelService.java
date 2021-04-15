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
		List<Country> countries = new ArrayList<Country>();
		try {
        String sql ="select * from countries";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	Country ct = new Country();
            ct.setId(rs.getInt("id_country"));
            ct.setName(rs.getString("countryName"));
            countries.add(ct);
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return countries;
	}
	
	
	// get All destinations per city
    public List<Destination> getDestinationsByCity(int id) {
        List<Destination> cityDest  = new ArrayList<Destination>();
        try {
            String sql ="SELECT * FROM destinations JOIN dest_type on destinations.typeDest = dest_type.id where city_id =? ";
            db.myPrepareStatement(sql);
            Object[] parameters = {id};
            db.addParameters(parameters);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
            	Destination dt = new Destination();
                dt.setId(rs.getInt("id"));
                dt.setNameDest(rs.getString("nameDest"));
                dt.setTypeDest(rs.getInt("typeDest"));
                dt.setDestName(rs.getString("destType"));
                cityDest.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityDest;
    }
    
    //All cities 
    public List<City> getCities() {
        List<City> cityType  = new ArrayList<City>();
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
                
                cityType.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityType;
    }

    // get list of destinations types
	public List<DestType> getDestTypes() {
		List<DestType> destTypeList = new ArrayList<DestType>();
		try {
        String sql ="select * from dest_type";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	DestType dest_type = new DestType();
        	dest_type.setId(rs.getInt("id"));
        	dest_type.setDestType(rs.getString("destType"));
        	dest_type.setImg_link(rs.getString("img_link"));
        	destTypeList.add(dest_type);
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return destTypeList;
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
	                DestinationName destName = new DestinationName();
	                destName.setId(rs.getInt("id"));
	                destName.setNameDest(rs.getString("nameDest"));
	                destName.setTyDest(rs.getInt("typeDest"));
	                destName.setCity_id(rs.getInt("city_id"));
	                destName.setCityName(rs.getString("name"));
	                dn.add(destName);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dn;
	}
    
}

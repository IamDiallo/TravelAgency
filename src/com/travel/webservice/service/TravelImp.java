package com.travel.webservice.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.travel.webservice.model.Cities;
import com.travel.webservice.model.Countries;
import com.travel.webservice.model.DEST_TYPE;
import com.travel.webservice.model.DataBaseHelper;
import com.travel.webservice.model.DestName;
import com.travel.webservice.model.Destinations;


@WebService(targetNamespace = "http://service.webservice.travel.com/",
endpointInterface = "com.travel.webservice.service.Travel",
portName = "TravelPort",serviceName = "TravelService")
public class TravelImp implements Travel{

	DataBaseHelper db = DataBaseHelper.getInstance();
	@WebMethod(operationName = "getCountry", action = "urn:GetCountry")
	@WebResult(name = "return")
	public List<Countries> getCountry() {  // get the list of all countries
		// TODO Auto-generated method stub
		List<Countries> countries = new ArrayList<Countries>();
		try {
        String sql ="select * from countries";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	Countries ct = new Countries();
            ct.setId(rs.getInt("id"));
            ct.setName(rs.getString("name"));
            ct.setContinent(rs.getString("continent"));
            countries.add(ct);
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return countries;
	}
	
	
	//All destination per city
    public List<Destinations> getDestinationsByCity(int id) {
        List<Destinations> cityDest  = new ArrayList<Destinations>();
        try {
            String sql ="SELECT * FROM destinations JOIN dest_type on destinations.typeDest = dest_type.id where city_id =? ";
            db.myPrepareStatement(sql);
            Object[] parameters = {id};
            db.addParameters(parameters);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
                Destinations dt = new Destinations();
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
    
  //All cities per Diestination type

    public List<Cities> getCities() {
        List<Cities> cityType  = new ArrayList<Cities>();
        try {
        	String sql ="Select * from cities join countries on cities.country_id = countries.id_country";
            db.myPrepareStatement(sql);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
                Cities ct = new Cities();
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

    // list of destinations
	public List<DEST_TYPE> getDestinations() {
		List<DEST_TYPE> destTypeList = new ArrayList<DEST_TYPE>();
		try {
        String sql ="select * from dest_type";
        db.myPrepareStatement(sql);
        ResultSet rs = db.myExecuteQuery();
        while(rs.next()) {
        	DEST_TYPE dest_type = new DEST_TYPE();
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



	public List<DestName> getDestName(int idDestType) {
		// TODO Auto-generated method stub
		 List<DestName> dn  = new ArrayList<DestName>();
		 try {
	            String sql ="SELECT * FROM destinations join dest_type on destinations.typeDest = ? JOIN cities on destinations.city_id =cities.id group by nameDest";
	            db.myPrepareStatement(sql);
	            Object[] parameters = {idDestType};
	            db.addParameters(parameters);
	            ResultSet rs = db.myExecuteQuery();
	            while(rs.next()) {
	                DestName destName = new DestName();
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


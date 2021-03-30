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
            String sql ="select * from destinations where city_id = ?";
            db.myPrepareStatement(sql);
            Object[] parameters = {id};
            db.addParameters(parameters);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
                Destinations dt = new Destinations();
                dt.setId(rs.getInt("id"));
                dt.setNameDest(rs.getString("nameDest"));
                dt.setTypeDest(rs.getInt("typeDest"));
                
                cityDest.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityDest;
    }
    
  //All cities per Diestination type

    public List<Cities> getCitiesByTypeDest(String type_dest) {
        List<Cities> cityType  = new ArrayList<Cities>();
        try {
        	 String sql ="SELECT * FROM cities c, destinations d WHERE c.id = d.city_id AND d.typeDest = ?";
            db.myPrepareStatement(sql);
            Object[] parameters = {type_dest};
            db.addParameters(parameters);
            ResultSet rs = db.myExecuteQuery();
            while(rs.next()) {
                Cities ct = new Cities();
                ct.setId(rs.getInt("id"));
                ct.setName(rs.getString("name"));
                
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
        	destTypeList.add(dest_type);
        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
		return destTypeList;
	}
    


}


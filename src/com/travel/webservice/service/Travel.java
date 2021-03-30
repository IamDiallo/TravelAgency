package com.travel.webservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.travel.webservice.model.Cities;
import com.travel.webservice.model.Countries;
import com.travel.webservice.model.DEST_TYPE;
import com.travel.webservice.model.Destinations;


@WebService(name = "Travel",targetNamespace = "http://service.webservice.travel.com/")
public interface Travel {

	@WebMethod(operationName = "getCountry", action = "urn:GetCountry")
	@WebResult(name = "result")
	List<Countries> getCountry();
	
	@WebMethod(operationName = "getDestinations", action = "urn:GetDestinations")
	@WebResult(name = "result")
	List<DEST_TYPE> getDestinations();
	
	@WebMethod(operationName = "getDestinationsByCity", action = "urn:GetDestinationsByCity")
	@WebResult(name = "result")
	List<Destinations> getDestinationsByCity(@WebParam(name="idCity") int id);
	
	@WebMethod(operationName = "getCitiesByTypeDest", action = "urn:GetCitiesByTypeDest")
	@WebResult(name = "result")
	List<Cities> getCitiesByTypeDest(@WebParam(name="TypeDest") String type_dest);
	
	

}


package com.travel.webservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.travel.webservice.model.City;
import com.travel.webservice.model.Country;
import com.travel.webservice.model.DestGroup;
import com.travel.webservice.model.DestType;
import com.travel.webservice.model.DestinationName;
import com.travel.webservice.model.Destination;

// interface of the implementation class 
@WebService(name = "Travel",targetNamespace = "http://service.webservice.travel.com/")
public interface Travel {

	/*List of WebMethod that will allow the generation of the operation in the wdsl file*/
	@WebMethod(operationName = "getCountry", action = "urn:GetCountry")
	@WebResult(name = "result")
	List<Country> getCountry();
	
	@WebMethod(operationName = "getDestinations", action = "urn:GetDestinations")
	@WebResult(name = "result")
	List<DestType> getDestinations();
	
	@WebMethod(operationName = "getDestinationsByCity", action = "urn:GetDestinationsByCity")
	@WebResult(name = "result")
	List<Destination> getDestinationsByCity(@WebParam(name="idCity") int id);
	
	@WebMethod(operationName = "getCities", action = "urn:GetCities")
	@WebResult(name = "result")
	List<City> getCities();
	
	@WebMethod(operationName = "getDestinationName", action = "urn:GetDestinationName")
	@WebResult(name = "result")
	List<DestinationName> getDestinationName(@WebParam(name="idDestType") int idDestType);
	
	@WebMethod(operationName = "getDestGroup", action = "urn:GetDestGroup")
	@WebResult(name = "result")
	List<DestGroup> getDestGroup();
}


package com.travel.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Cities")
public class City {
	int id;
	int idCountry;
	String name;
	String countryName;
	float longitude;
	float latitude;
	String cityImg;
	
	
	public City() {
		super();
	}


	public City(int id, int idCountry, String name, String countryName, float longitude, float latitude,
			String cityImg) {
		super();
		this.id = id;
		this.idCountry = idCountry;
		this.name = name;
		this.countryName = countryName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.cityImg = cityImg;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdCountry() {
		return idCountry;
	}


	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public String getCityImg() {
		return cityImg;
	}


	public void setCityImg(String cityImg) {
		this.cityImg = cityImg;
	}
	
	
	
	
	
	
}

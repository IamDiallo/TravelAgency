package com.travel.webservice.model;

public class DestinationName {
   int id;
   String nameDest;
   String cityName;
   int typeDest;
   int city_id;
   String img;

	public DestinationName() {
		super();
	}
	
	

	public DestinationName(int id, String nameDest, String cityName, int typeDest, int city_id, String img) {
		super();
		this.id = id;
		this.nameDest = nameDest;
		this.cityName = cityName;
		this.typeDest = typeDest;
		this.city_id = city_id;
		this.img = img;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameDest() {
		return nameDest;
	}

	public void setNameDest(String nameDest) {
		this.nameDest = nameDest;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getTypeDest() {
		return typeDest;
	}

	public void setTypeDest(int typeDest) {
		this.typeDest = typeDest;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}
	
   
}

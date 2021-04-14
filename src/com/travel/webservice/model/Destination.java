package com.travel.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Destination")
public class Destination {
	
	int id;
	String nameDest;
	int typeDest;
	int cityDest;
	String img;
	String destName;
	
	
	public Destination() {
		super();
	}


	public Destination(int id, String nameDest, int typeDest, int cityDest, String img, String destName) {
		super();
		this.id = id;
		this.nameDest = nameDest;
		this.typeDest = typeDest;
		this.cityDest = cityDest;
		this.img = img;
		this.destName = destName;
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


	public int getTypeDest() {
		return typeDest;
	}


	public void setTypeDest(int typeDest) {
		this.typeDest = typeDest;
	}


	public int getCityDest() {
		return cityDest;
	}


	public void setCityDest(int cityDest) {
		this.cityDest = cityDest;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getDestName() {
		return destName;
	}


	public void setDestName(String destName) {
		this.destName = destName;
	}
	
	
}

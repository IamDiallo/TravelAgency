package com.travel.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Destination")
public class Destination {
	int id;
	String nameDest;
	int typeDest;
	String destName;
	String img;
	
	public Destination() {
		super();
	}
	
	
	public Destination(int id, String nameDest, int typeDest, String destName, String img) {
		super();
		this.id = id;
		this.nameDest = nameDest;
		this.typeDest = typeDest;
		this.destName = destName;
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
	
	public int getTypeDest() {
		return typeDest;
	}
	
	public void setTypeDest(int typeDest) {
		this.typeDest = typeDest;
	}
	
	public String getDestName() {
		return destName;
	}
	
	public void setDestName(String destName) {
		this.destName = destName;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
	
	
	  
}

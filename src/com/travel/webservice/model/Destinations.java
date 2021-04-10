package com.travel.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Destinations")
public class Destinations {
  int id;
  String nameDest;
  int typeDest;
  String destName;
public Destinations(int id, String nameDest, int typeDest, String destName) {
	super();
	this.id = id;
	this.nameDest = nameDest;
	this.typeDest = typeDest;
	this.destName = destName;
}
public Destinations() {
	super();
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
  
}

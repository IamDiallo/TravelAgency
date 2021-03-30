package com.travel.webservice.model;

public class Destinations {
  int id;
  String nameDest;
  int typeDest;
  
public Destinations() {
	super();
}
public Destinations(int id, String nameDest, int typeDest) {
	super();
	this.id = id;
	this.nameDest = nameDest;
	this.typeDest = typeDest;
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
}

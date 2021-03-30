package com.travel.webservice.model;

public class Cities {
	
public Cities() {
   super();
}
public Cities(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
int id;
  String name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}

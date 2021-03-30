package com.travel.webservice.model;

public class DEST_TYPE {
 int id;
 String destType;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDestType() {
	return destType;
}
public void setDestType(String destType) {
	this.destType = destType;
}
public DEST_TYPE() {
	super();
}
public DEST_TYPE(int id, String destType) {
	super();
	this.id = id;
	this.destType = destType;
}
}

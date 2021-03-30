package com.travel.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Countries")
public class Countries {
	private int id;
	private String name;
	private String continent;
	
	public Countries() {
		super();
	}

	public Countries(int id, String name, String continent) {
		super();
		this.id = id;
		this.name = name;
		this.continent = continent;
	}

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

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	
}
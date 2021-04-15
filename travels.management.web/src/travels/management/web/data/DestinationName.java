package travels.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="destName")
public class DestinationName {
	int id;
	String nameDest;
	String cityName;
	int tyDest;
	int city_id;
   
	public DestinationName() {
		super();
	}
	
	public DestinationName(int id, String nameDest, int tyDest, int city_id, String cityName) {
		super();
		this.id = id;
		this.nameDest = nameDest;
		this.tyDest = tyDest;
		this.city_id = city_id;
		this.cityName = cityName;
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
	
	public int getTyDest() {
		return tyDest;
	}
	
	public void setTyDest(int tyDest) {
		this.tyDest = tyDest;
	}
	
	public int getCity_id() {
		return city_id;
	}
	
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


}

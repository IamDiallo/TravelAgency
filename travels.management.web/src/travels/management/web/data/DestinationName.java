package travels.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="destName")
public class DestinationName {
	int id;
	String nameDest;
	String cityName;
	String nameTypeDest;
	int tyDest;
	int city_id;
	String img;
   
	public DestinationName() {
		super();
	}


	public DestinationName(int id, String nameDest, String cityName, String nameTypeDest, int tyDest, int city_id,
			String img) {
		super();
		this.id = id;
		this.nameDest = nameDest;
		this.cityName = cityName;
		this.nameTypeDest = nameTypeDest;
		this.tyDest = tyDest;
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



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}


	public String getNameTypeDest() {
		return nameTypeDest;
	}


	public void setNameTypeDest(String nameTypeDest) {
		this.nameTypeDest = nameTypeDest;
	}
	
	


}

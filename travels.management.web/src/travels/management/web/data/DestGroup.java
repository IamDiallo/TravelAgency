package travels.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DestGroup")
public class DestGroup {

	int destiId;
	int destCount;
	String cityName;
	float longitude;
	float latitude;
	
	public DestGroup() {
		super();
	}

	public DestGroup(int destiId, int destCount, String cityName, float longitude, float latitude) {
		super();
		this.destiId = destiId;
		this.destCount = destCount;
		this.cityName = cityName;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getDestiId() {
		return destiId;
	}

	public void setDestiId(int destiId) {
		this.destiId = destiId;
	}

	public int getDestCount() {
		return destCount;
	}

	public void setDestCount(int destCount) {
		this.destCount = destCount;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	
}

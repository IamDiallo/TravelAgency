package com.travel.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DEST_TYPE")
public class DestType {
	 int id;
	 String destType;
	 String img_link;
	 
	public DestType(int id, String destType, String img_link)
	{
		super();
		this.id = id;
		this.destType = destType;
		this.img_link = img_link;
	}
	public DestType() 
	{
		super();
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getDestType()
	{
		return destType;
	}
	public void setDestType(String destType)
	{
		this.destType = destType;
	}
	public String getImg_link()
	{
		return img_link;
	}
	public void setImg_link(String img_link)
	{
		this.img_link = img_link;
	}

}


package com.travel.webservice.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Wed Apr 14 19:07:28 CEST 2021
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "addDest", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDest", namespace = "http://service.webservice.travel.com/", propOrder = {"dest", "typeDest", "city_id", "img"})

public class AddDest {

    @XmlElement(name = "dest")
    private java.lang.String dest;
    @XmlElement(name = "typeDest")
    private java.lang.String typeDest;
    @XmlElement(name = "city_id")
    private int city_id;
    @XmlElement(name = "img")
    private java.lang.String img;

    public java.lang.String getDest() {
        return this.dest;
    }

    public void setDest(java.lang.String newDest)  {
        this.dest = newDest;
    }

    public java.lang.String getTypeDest() {
        return this.typeDest;
    }

    public void setTypeDest(java.lang.String newTypeDest)  {
        this.typeDest = newTypeDest;
    }

    public int getCity_id() {
        return this.city_id;
    }

    public void setCity_id(int newCity_id)  {
        this.city_id = newCity_id;
    }

    public java.lang.String getImg() {
        return this.img;
    }

    public void setImg(java.lang.String newImg)  {
        this.img = newImg;
    }

}


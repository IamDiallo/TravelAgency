
package com.travel.webservice.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Wed Apr 14 19:07:29 CEST 2021
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "getDestinationsByCity", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDestinationsByCity", namespace = "http://service.webservice.travel.com/")

public class GetDestinationsByCity {

    @XmlElement(name = "idCity")
    private int idCity;

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int newIdCity)  {
        this.idCity = newIdCity;
    }

}



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

@XmlRootElement(name = "getDestinationName", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDestinationName", namespace = "http://service.webservice.travel.com/")

public class GetDestinationName {

    @XmlElement(name = "idDestType")
    private int idDestType;

    public int getIdDestType() {
        return this.idDestType;
    }

    public void setIdDestType(int newIdDestType)  {
        this.idDestType = newIdDestType;
    }

}



package com.travel.webservice.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Thu Apr 15 16:37:44 CEST 2021
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "getDest", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDest", namespace = "http://service.webservice.travel.com/")

public class GetDest {

    @XmlElement(name = "id")
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int newId)  {
        this.id = newId;
    }

}


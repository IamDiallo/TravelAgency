
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

@XmlRootElement(name = "getDestinationNameResponse", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDestinationNameResponse", namespace = "http://service.webservice.travel.com/")

public class GetDestinationNameResponse {

    @XmlElement(name = "result")
    private java.util.List<com.travel.webservice.model.DestinationName> result;

    public java.util.List<com.travel.webservice.model.DestinationName> getResult() {
        return this.result;
    }

    public void setResult(java.util.List<com.travel.webservice.model.DestinationName> newResult)  {
        this.result = newResult;
    }

}


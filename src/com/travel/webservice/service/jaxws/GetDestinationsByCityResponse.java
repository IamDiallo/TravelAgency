
package com.travel.webservice.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Sat Apr 10 17:51:04 CEST 2021
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "getDestinationsByCityResponse", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDestinationsByCityResponse", namespace = "http://service.webservice.travel.com/")

public class GetDestinationsByCityResponse {

    @XmlElement(name = "result")
    private java.util.List<com.travel.webservice.model.Destination> result;

    public java.util.List<com.travel.webservice.model.Destination> getResult() {
        return this.result;
    }

    public void setResult(java.util.List<com.travel.webservice.model.Destination> newResult)  {
        this.result = newResult;
    }

}


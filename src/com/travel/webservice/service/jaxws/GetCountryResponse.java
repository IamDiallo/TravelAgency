
package com.travel.webservice.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Mon Apr 12 19:53:33 CEST 2021
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "getCountryResponse", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCountryResponse", namespace = "http://service.webservice.travel.com/")

public class GetCountryResponse {

    @XmlElement(name = "result")
    private java.util.List<com.travel.webservice.model.Country> result;

    public java.util.List<com.travel.webservice.model.Country> getResult() {
        return this.result;
    }

    public void setResult(java.util.List<com.travel.webservice.model.Country> newResult)  {
        this.result = newResult;
    }

}


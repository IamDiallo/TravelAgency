
package com.travel.webservice.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Fri Apr 09 01:30:12 CEST 2021
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "getDestinationsResponse", namespace = "http://service.webservice.travel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDestinationsResponse", namespace = "http://service.webservice.travel.com/")

public class GetDestinationsResponse {

    @XmlElement(name = "result")
    private java.util.List<com.travel.webservice.model.DEST_TYPE> result;

    public java.util.List<com.travel.webservice.model.DEST_TYPE> getResult() {
        return this.result;
    }

    public void setResult(java.util.List<com.travel.webservice.model.DEST_TYPE> newResult)  {
        this.result = newResult;
    }

}


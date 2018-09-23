package com.casenet.xmlModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class AddressXml {

    private String street;
    private Integer number;

    public String getStreet() {
        return street;
    }

    @XmlElement(name = "street")
    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    @XmlElement(name = "number")
    public void setNumber(Integer number) {
        this.number = number;
    }
}

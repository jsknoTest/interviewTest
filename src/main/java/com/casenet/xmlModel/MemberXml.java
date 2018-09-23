package com.casenet.xmlModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "member")
public class MemberXml {

    private String name;
    private List<AddressXml> addresses;
    private List<String> diagnoses;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public List<AddressXml> getAddresses() {
        return addresses;
    }

    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "address")
    public void setAddresses(List<AddressXml> addresses) {
        this.addresses = addresses;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    @XmlElementWrapper(name = "diagnoses")
    @XmlElement(name = "diagnosis")
    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }
}

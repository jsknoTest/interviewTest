package com.casenet.xmlModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "health-company")
public class HealtCompanyXml {

    List<MemberXml> members;

    public List<MemberXml> getMembers() {
        return members;
    }

    @XmlElementWrapper(name = "members")
    @XmlElement(name = "member")
    public void setMembers(List<MemberXml> members) {
        this.members = members;
    }
}

package com.arthsoft.osmd.entity;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by arthk on 07.09.2017.
 */
public class Benefit extends Entity {      //table  `benefits`


    private int typeId;     //  `TypeID` int(11) NOT NULL,REFERENCES `benefitstypes`
    private int peopleId;   //  `PeopleID` int(11) NOT NULL,REFERENCES `people` (`ID`)
    private float benefitPercent;    //  `BenefitPercent` decimal(5,2) DEFAULT NULL,
    private int serviceId;  //  `ServiceID` int(11) DEFAULT NULL,REFERENCES `services` (`ID`)
    private String name;    //  `Name` char(50) DEFAULT NULL,


    @Override
    public String toString() {
        return "Benefit{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", typeId=" + typeId +
                ", peopleId=" + peopleId +
                ", benefitPercent=" + benefitPercent +
                ", serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public float getBenefitPercent() {
        return benefitPercent;
    }

    public void setBenefitPercent(float benefitPercent) {
        this.benefitPercent = benefitPercent;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

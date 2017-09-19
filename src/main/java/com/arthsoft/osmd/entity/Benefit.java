package com.arthsoft.osmd.entity;

import java.util.Date;

/**
 * Created by arthk on 07.09.2017.
 */
public class Benefit {      //table  `benefits`

    private int id; //            `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private boolean active; //  `Active` tinyint(1) NOT NULL,
    private int typeId;     //  `TypeID` int(11) NOT NULL,REFERENCES `benefitstypes`
    private int peopleId;   //  `PeopleID` int(11) NOT NULL,REFERENCES `people` (`ID`)
    private float benefitPercent;    //  `BenefitPercent` decimal(5,2) DEFAULT NULL,
    private int serviceId;  //  `ServiceID` int(11) DEFAULT NULL,REFERENCES `services` (`ID`)
    private String name;    //  `Name` char(50) DEFAULT NULL,
    private String remark;  //  `Remark` longtext,
    private java.util.Date lastUpdate;      //     `LastUpdate` date NOT NULL


    public Benefit(int id, boolean active, int typeId, int peopleId, float benefitPercent, int serviceId, String name, String remark, Date lastUpdate) {
        this.id = id;
        this.active = active;
        this.typeId = typeId;
        this.peopleId = peopleId;
        this.benefitPercent = benefitPercent;
        this.serviceId = serviceId;
        this.name = name;
        this.remark = remark;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

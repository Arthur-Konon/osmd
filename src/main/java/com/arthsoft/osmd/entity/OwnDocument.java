package com.arthsoft.osmd.entity;

import java.util.Date;

/**
 * Created by arthk on 08.09.2017.
 */
public class OwnDocument {      //table `owndocuments`

    private int id; //     `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private boolean active; //  `Active` tinyint(1) NOT NULL,
    private String name;    //  `Name` char(100) NOT NULL,
    private String number;  //  `Number` char(10) NOT NULL,
    private java.util.Date startDate;   //  `StartDate` date NOT NULL,
    private String remark;  //        `Remark` longtext,
    private java.util.Date lastUpdate;      //     `LastUpdate` char(10) NOT NULL


    public OwnDocument(int id, boolean active, String name, String number, Date startDate, String remark, Date lastUpdate) {
        this.id = id;
        this.active = active;
        this.name = name;
        this.number = number;
        this.startDate = startDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

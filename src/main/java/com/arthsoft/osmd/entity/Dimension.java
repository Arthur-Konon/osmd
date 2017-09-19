package com.arthsoft.osmd.entity;
import java.util.Date;

/**
 * Created by arthk on 07.09.2017.
 */
public class Dimension {       //table  `dimensions`

private int id;     //     `ID` int(11) NOT NULL AUTO_INCREMENT,  PRIMARY KEY
    private boolean  active;    //  `Active` tinyint(1) NOT NULL,
    private String name;    //  `Name` char(10) NOT NULL,
    private String remark;  // `Remark` longtext,
    private java.util.Date  lastUpdate;     // `LastUpdate` date NOT NULL


    public Dimension(int id, boolean active, String name, String remark, Date lastUpdate) {
        this.id = id;
        this.active = active;
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

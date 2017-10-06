package com.arthsoft.osmd.entity;

import java.time.LocalDate;

/**
 * Created by arthk on 20.09.2017.
 */
public abstract class Entity {



    private int id;     //  `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private boolean active; //  `Active` tinyint(1) NOT NULL,
    private String remark;      //  `Remark` longtext,
    private LocalDate lastUpdate;      // `LastUpdate` date NOT NULL




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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }



}

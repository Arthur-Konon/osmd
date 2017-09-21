package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 31.08.2017.
 */
public class Owner {    // owners
    private int id;         //`     ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private boolean active; //      `Active` tinyint(1) NOT NULL,
    private int peopleId;   //    `PeopleID` int(11) NOT NULL,
    private int ownApartId; //    `OwnApartID` int(11) NOT NULL,REFERENCES `apartments` (`ID`)
    private int ownPart;    //      `OwnPart` tinyint(3) unsigned DEFAULT NULL,
    private int ownDocId;       //    `OwnDocID` int(11) DEFAULT NULL,REFERENCES `owndocuments` (`ID`)
    private boolean senior;      //  `Senior` tinyint(1) DEFAULT NULL,
    private String  remark;    // `Remark` longtext,
    private java.util.Date lastUpdate;  // `LastUpdate` date NOT NULL

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", active=" + active +
                ", peopleId=" + peopleId +
                ", ownApartId=" + ownApartId +
                ", ownPart=" + ownPart +
                ", ownDocId=" + ownDocId +
                ", senior=" + senior +
                ", remark='" + remark + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public int getOwnApartId() {
        return ownApartId;
    }

    public int getOwnPart() {
        return ownPart;
    }

    public int getOwnDocId() {
        return ownDocId;
    }

    public boolean isSenior() {
        return senior;
    }

    public String getRemark() {
        return remark;
    }

    public java.util.Date getLastUpdate() {
        return lastUpdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public void setOwnApartId(int ownApartId) {
        this.ownApartId = ownApartId;
    }

    public void setOwnPart(int ownPart) {
        this.ownPart = ownPart;
    }

    public void setOwnDocId(int ownDocId) {
        this.ownDocId = ownDocId;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setLastUpdate(java.util.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

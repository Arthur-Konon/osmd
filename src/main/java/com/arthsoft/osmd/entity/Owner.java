package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 31.08.2017.
 */
public class Owner extends Entity {    // owners

    private int peopleId;   //    `PeopleID` int(11) NOT NULL,
    private int ownApartId; //    `OwnApartID` int(11) NOT NULL,REFERENCES `apartments` (`ID`)
    private int ownPart;    //      `OwnPart` tinyint(3) unsigned DEFAULT NULL,
    private int ownDocId;       //    `OwnDocID` int(11) DEFAULT NULL,REFERENCES `owndocuments` (`ID`)
    private boolean senior;      //  `Senior` tinyint(1) DEFAULT NULL,

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", peopleId=" + peopleId +
                ", ownApartId=" + ownApartId +
                ", ownPart=" + ownPart +
                ", ownDocId=" + ownDocId +
                ", senior=" + senior +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public int getOwnApartId() {
        return ownApartId;
    }

    public void setOwnApartId(int ownApartId) {
        this.ownApartId = ownApartId;
    }

    public int getOwnPart() {
        return ownPart;
    }

    public void setOwnPart(int ownPart) {
        this.ownPart = ownPart;
    }

    public int getOwnDocId() {
        return ownDocId;
    }

    public void setOwnDocId(int ownDocId) {
        this.ownDocId = ownDocId;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }
}

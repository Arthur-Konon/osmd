package com.arthsoft.osmd.entity;
import java.time.LocalDate;


/**
 * Created by arthk on 07.09.2017.
 */
public class BenefitsType {     //table `benefitstypes`

    private int id; //            `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private boolean active; //  `Active` tinyint(1) NOT NULL,
    private String name;    //  `Name` varchar(50) DEFAULT NULL,
    private String remark;  //  `Remark` longtext,
    private LocalDate lastUpdate;  //     `LastUpdate` date NOT NULL,




    @Override
    public String toString() {
        return "BenefitsType{" +
                "id=" + id +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
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

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

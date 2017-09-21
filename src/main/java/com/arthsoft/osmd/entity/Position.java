package com.arthsoft.osmd.entity;
import java.util.Date;

/**
 * Created by arthk on 08.09.2017.
 */
public class Position {    //    table `positions`

    private int id;             //       `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private String name;        //  `Position` varchar(50) NOT NULL,
    private boolean ispaid;     //  `IsPaid` tinyint(1) DEFAULT NULL,
    private boolean isStated;   //  `IsStated` tinyint(1) DEFAULT NULL,
    private String Remark;      //  `Remark` longtext,
    private java.util.Date lastUpdate;   //     `LastUpdate` date NOT NULL,

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ispaid=" + ispaid +
                ", isStated=" + isStated +
                ", Remark='" + Remark + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIspaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }

    public boolean isStated() {
        return isStated;
    }

    public void setStated(boolean stated) {
        isStated = stated;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

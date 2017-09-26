package com.arthsoft.osmd.entity;
import java.time.LocalDate;


/**
 * Created by arthk on 07.09.2017.
 */
public class BenefitsType extends Entity {     //table `benefitstypes`


    private String name;    //  `Name` varchar(50) DEFAULT NULL,

    @Override
    public String toString() {
        return "BenefitsType{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", name='" + name + '\'' +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

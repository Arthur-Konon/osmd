package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 07.09.2017.
 */
public class Dimension extends Entity {       //table  `dimensions`


    private String name;    //  `Name` char(10) NOT NULL,

    @Override
    public String toString() {
        return "Dimension{" +
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

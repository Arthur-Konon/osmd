package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 08.09.2017.
 */
public class Position extends Entity {    //    table `positions`


    private String name;        //  `Name` varchar(50)
    private boolean paid;     //  `Paid` tinyint(1) DEFAULT NULL,
    private boolean stated;   //  `Stated` tinyint(1) DEFAULT NULL,


    @Override
    public String toString() {
        return "Position{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", name='" + name + '\'' +
                ", isPaid=" + isPaid() +
                ", isStated=" + isStated() +
                ", Remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isStated() {
        return stated;
    }

    public void setStated(boolean stated) {
        this.stated = stated;
    }
}

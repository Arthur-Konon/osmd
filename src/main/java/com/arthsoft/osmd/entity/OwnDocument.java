package com.arthsoft.osmd.entity;

import java.time.LocalDate;

/**
 * Created by arthk on 08.09.2017.
 */
public class OwnDocument extends Entity {      //table `owndocuments`


    private String name;    //  `Name` char(100) NOT NULL,
    private String number;  //  `Number` char(10) NOT NULL,
    private LocalDate startDate;   //  `StartDate` date NOT NULL,


    @Override
    public String toString() {
        return "OwnDocument{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", startDate=" + startDate +
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

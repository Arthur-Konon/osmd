package com.arthsoft.osmd.entity;

import java.time.LocalDate;

/**
 * Created by arthk on 07.09.2017.
 */

public class House extends Entity {        //table `houses`

    private String address; //  `Address` nvarchar(50) NOT NULL,
    private int year;   //  `Year` smallint(6) DEFAULT NULL,
    private int qtyOfStoreys;   //  `QtyOfStoreys` smallint(6) DEFAULT NULL,
    private int qtyOfAllApart;  //  `QtyOfAllApart` smallint(6) DEFAULT NULL,
    private float totalArea;    //  `TotalArea` decimal(10,2) DEFAULT NULL,
    private float areaOfAllApart;   //  `AreOfAllApart` decimal(10,2) DEFAULT NULL,


    @Override
    public String toString() {
        return "House{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", address='" + address + '\'' +
                ", year=" + year +
                ", qtyOfStoreys=" + qtyOfStoreys +
                ", qtyOfAllApart=" + qtyOfAllApart +
                ", totalArea=" + totalArea +
                ", areaOfAllApart=" + areaOfAllApart +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQtyOfStoreys() {
        return qtyOfStoreys;
    }

    public void setQtyOfStoreys(int qtyOfStoreys) {
        this.qtyOfStoreys = qtyOfStoreys;
    }

    public int getQtyOfAllApart() {
        return qtyOfAllApart;
    }

    public void setQtyOfAllApart(int qtyOfAllApart) {
        this.qtyOfAllApart = qtyOfAllApart;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public float getAreaOfAllApart() {
        return areaOfAllApart;
    }

    public void setAreaOfAllApart(float areaOfAllApart) {
        this.areaOfAllApart = areaOfAllApart;
    }

}

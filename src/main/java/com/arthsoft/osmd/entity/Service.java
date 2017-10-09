package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 08.09.2017.
 */
public class Service extends Entity {      //table `services`

    private String name;        //  `Name` char(50) NOT NULL,
    private float price;        //  `Price` decimal(5,2) NOT NULL,
    private int dimensionId;    // `DimensionID` int(11) NOT NULL,REFERENCES `dimensions` (`ID`)


    @Override
    public String toString() {
        return "Service{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dimensionId=" + dimensionId +
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(int dimensionId) {
        this.dimensionId = dimensionId;
    }
}

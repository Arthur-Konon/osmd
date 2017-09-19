package osmd.entity;

import java.util.Date;

/**
 * Created by arthk on 08.09.2017.
 */
public class Service {      //table `services`
    private int id;             //  `ID` int(11) NOT NULL AUTO_INCREMENT, PRIMARY KEY
    private boolean active;     //  `Active` tinyint(1) NOT NULL,
    private String name;        //  `Name` char(50) NOT NULL,
    private float price;        //  `Price` decimal(5,2) NOT NULL,
    private int dimensionId;    // `DimensionID` int(11) NOT NULL,REFERENCES `dimensions` (`ID`)
    private String remark;      //  `Remark` longtext,
    private java.util.Date lastUpdate;      // `LastUpdate` date NOT NULL

    public Service(int id, boolean active, String name, float price, int demensionId, String remark, Date lastUpdate) {
        this.id = id;
        this.active = active;
        this.name = name;
        this.price = price;
        this.dimensionId = demensionId;
        this.remark = remark;
        this.lastUpdate = lastUpdate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

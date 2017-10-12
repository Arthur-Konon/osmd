package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 04.09.2017.
 */
public class Apartment extends Entity {         //table       `apartments`

    private int houseId;            //  `HouseID` int(11) NOT NULL,REFERENCES `houses` (`ID`)
    private int apartNum;         //  `ApartNum` smallint(6) NOT NULL,
    private int supervisorId;         //  int(11) DEFAULT NULL,REFERENCES `people` (`ID`)
    private float totalArea;         //  TotalArea decimal(7, 2) NULL,
    private float heatedArea;        // `HeatedArea` decimal(7,2) DEFAULT NULL,
    private float usefulArea;       //   `UsefulArea` decimal(7,2) DEFAULT NULL,
    private boolean privacy;       //  `Privacy` tinyint(1) DEFAULT NULL,
    private String cellPhone;        // `CellPhone` char(10) DEFAULT NULL,
    private byte regTenantQty;      //  `RegTenantsQty` tinyint(3) unsigned DEFAULT NULL,
    private byte actTenantsQty;     //    `ActTenantsQty` tinyint(3) unsigned DEFAULT NULL,
    private boolean residentialFund;   //  `ResidentialFund` tinyint(1) DEFAULT NULL,

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", houseId=" + houseId +
                ", apartNum=" + apartNum +
                ", supervisorId=" + supervisorId +
                ", totalArea=" + totalArea +
                ", heatedArea=" + heatedArea +
                ", usefulArea=" + usefulArea +
                ", privacy=" + privacy +
                ", cellPhone='" + cellPhone + '\'' +
                ", regTenantQty=" + regTenantQty +
                ", actTenantsQty=" + actTenantsQty +
                ", residentialFund=" + residentialFund +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
    }


    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getApartNum() {
        return apartNum;
    }

    public void setApartNum(int apartNum) {
        this.apartNum = apartNum;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public float getHeatedArea() {
        return heatedArea;
    }

    public void setHeatedArea(float heatedArea) {
        this.heatedArea = heatedArea;
    }

    public float getUsefulArea() {
        return usefulArea;
    }

    public void setUsefulArea(float usefulArea) {
        this.usefulArea = usefulArea;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public byte getRegTenantQty() {
        return regTenantQty;
    }

    public void setRegTenantQty(byte regTenantQty) {
        this.regTenantQty = regTenantQty;
    }

    public byte getActTenantsQty() {
        return actTenantsQty;
    }

    public void setActTenantsQty(byte actTenantsQty) {
        this.actTenantsQty = actTenantsQty;
    }

    public boolean isResidentialFund() {
        return residentialFund;
    }

    public void setResidentialFund(boolean residentialFund) {
        this.residentialFund = residentialFund;
    }

}












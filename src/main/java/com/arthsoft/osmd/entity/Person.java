package com.arthsoft.osmd.entity;

import java.util.Date;

/**
 * Created by arthk on 08.09.2017.
 */
public class Person {       //table 'people'

    private int id;                 //  `ID` int(11) NOT NULL AUTO_INCREMENT, PRIMARY KEY
    private boolean active;        //  `Active` tinyint(1) NOT NULL,
    private String firstName;       //  `FirstName` varchar(50) DEFAULT NULL,
    private String lastName;        //  `LastName` varchar(50) NOT NULL,
    private String patronymic;    //  `Patronymic` varchar(50) DEFAULT NULL,
    private int residApartId;    //  `ResidApartID` int(11) DEFAULT NULL,REFERENCES `apartments` (`ID`)
    private int regApartId;         //  `RegApartID` int(11) DEFAULT NULL,REFERENCES `apartments` (`ID`)
    private java.util.Date birthDate;   //`BithDate` date DEFAULT NULL,
    private String  phone;          //     `Phone` varchar(50) DEFAULT NULL,
    private String taxNum;          //  `TaxNum` char(10) DEFAULT NULL,
    private String passportSeries;       // `PassportSeries` char(10) DEFAULT NULL,
    private String passportNum;         //  `PassportNum` char(50) DEFAULT NULL,
    private String issuedBy;             //  `IssuedBy` char(100) DEFAULT NULL,
    private java.util.Date issuedDate;      //  `IssuedDate` date DEFAULT NULL,
    private String remark;              //  `Remarks` longtext,
    private java.util.Date lastUpdate;       //  `LastUpdate` date NOT NULL

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", active=" + active +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", residApartId=" + residApartId +
                ", regApartId=" + regApartId +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", taxNum='" + taxNum + '\'' +
                ", passportSeries='" + passportSeries + '\'' +
                ", passportNum='" + passportNum + '\'' +
                ", issuedBy='" + issuedBy + '\'' +
                ", issuedDate=" + issuedDate +
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getResidApartId() {
        return residApartId;
    }

    public void setResidApartId(int residApartId) {
        this.residApartId = residApartId;
    }

    public int getRegApartId() {
        return regApartId;
    }

    public void setRegApartId(int regApartId) {
        this.regApartId = regApartId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
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

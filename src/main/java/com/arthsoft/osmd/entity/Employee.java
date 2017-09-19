package com.arthsoft.osmd.entity;

import java.util.Date;

/**
 * Created by arthk on 07.09.2017.
 */
public class Employee {     //table     `employees`
    private int id; //  `ID` int(11) NOT NULL AUTO_INCREMENT,  PRIMARY KEY
    private boolean active; // `Active` tinyint(1) NOT NULL,
    private int peopleId;   //  `PeopleID` int(11) DEFAULT NULL,REFERENCES `people` (`ID`)
    private int positionId; //   `PositionID` int(11) NOT NULL,REFERENCES `positions` (`ID`)
    private java.util.Date hireDate;   //         `HireDate` date DEFAULT NULL,
    private java.util.Date fireDate;    //       `FireDate` date DEFAULT NULL,
    private float salary;   //     `Salary` decimal(5,2) DEFAULT NULL,
    private String remark;  //  `Remark` longtext,
    private java.util.Date lastUpdate; //     `LastUpdate` date NOT NULL

    public Employee(int id, boolean active, int peopleId, int positionId, Date hiredate, Date fireDate, float salary, String remark, Date lastUpdate) {
        this.id = id;
        this.active = active;
        this.peopleId = peopleId;
        this.positionId = positionId;
        this.hireDate = hiredate;
        this.fireDate = fireDate;
        this.salary = salary;
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

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
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

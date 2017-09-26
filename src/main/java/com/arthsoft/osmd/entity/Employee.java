package com.arthsoft.osmd.entity;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by arthk on 07.09.2017.
 */
public class Employee extends Entity {     //table     `employees`

    private int peopleId;   //  `PeopleID` int(11) DEFAULT NULL,REFERENCES `people` (`ID`)
    private int positionId; //   `PositionID` int(11) NOT NULL,REFERENCES `positions` (`ID`)
    private LocalDate hireDate;   //         `HireDate` date DEFAULT NULL,
    private LocalDate fireDate;    //       `FireDate` date DEFAULT NULL,
    private float salary;   //     `Salary` decimal(7,2) DEFAULT NULL,

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", peopleId=" + peopleId +
                ", positionId=" + positionId +
                ", hireDate=" + hireDate +
                ", fireDate=" + fireDate +
                ", salary=" + salary +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getFireDate() {
        return fireDate;
    }

    public void setFireDate(LocalDate fireDate) {
        this.fireDate = fireDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}

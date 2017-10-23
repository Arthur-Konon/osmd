package com.arthsoft.osmd.entity;

import com.arthsoft.osmd.annotations.Name;

import java.time.LocalDate;

import static com.arthsoft.osmd.annotations.Language.EN;
import static com.arthsoft.osmd.annotations.Language.RU;

/**
 * Created by arthk on 07.09.2017.
 */
public class Employee extends Entity {     //table     `employees`

    @Name(language = EN, name = "people id")
    @Name(language = RU, name = "номер")
    private int peopleId;   //  `PeopleID` int(11) DEFAULT NULL,REFERENCES `people` (`ID`)
    @Name(language = EN, name = "position id")
    @Name(language = RU, name = "Должность")
    private int positionId; //   `PositionID` int(11) NOT NULL,REFERENCES `positions` (`ID`)
    @Name(language = EN, name = "hire.date")
    @Name(language = RU, name = "Дата приема")
    private LocalDate hireDate;   //         `HireDate` date DEFAULT NULL,
    @Name(language = EN, name = "fire.date")
    @Name(language = RU, name = "дата увольнения")
    private LocalDate fireDate;    //       `FireDate` date DEFAULT NULL,
    @Name(language = EN, name = "salary")
    @Name(language = RU, name = "Оклад")
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

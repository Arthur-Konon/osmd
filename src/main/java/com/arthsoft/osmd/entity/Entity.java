package com.arthsoft.osmd.entity;

import com.arthsoft.osmd.annotations.Name;

import java.time.LocalDate;

import static com.arthsoft.osmd.annotations.Language.EN;
import static com.arthsoft.osmd.annotations.Language.RU;

/**
 * Created by arthk on 20.09.2017.
 */
public abstract class Entity {

    @Name(language = EN, name = "id")
    @Name(language = RU, name = "айдишник")
    private int id;     //  `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    @Name(language = EN, name = "active")
    @Name(language = RU, name = "Активно")
    private boolean active; //  `Active` tinyint(1) NOT NULL,
    @Name(language = EN, name = "remark")
    @Name(language = RU, name = "Примечание")
    private String remark;      //  `Remark` longtext,
    @Name(language = EN, name = "last uptd")
    @Name(language = RU, name = "Дата изменения")
    private LocalDate lastUpdate;      // `LastUpdate` date NOT NULL


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}

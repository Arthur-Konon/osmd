package osmd.entity;

import java.time.LocalDate;

/**
 * Created by arthk on 08.09.2017.
 */
public class User {     //table  `users`
    private int id;     //  `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private boolean active;     //  `Active` tinyint(1) NOT NULL,
    private String login;       //  `Login` char(50) NOT NULL,
    private String password;       //  `Password` char(50) NOT NULL,
    private int peopleId;       //  `PeopleID` int(11) DEFAULT NULL,REFERENCES `people` (`ID`)
    private String remark;      //  `Remark` longtext,
    private LocalDate lastUpdate;      // `LastUpdate` date NOT NULL

    @Override
    public String toString() {
        return  id + " " + active + " " + login + " " + password + " " + peopleId + " " +  remark + " " + lastUpdate;
    }

    public User(){
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
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

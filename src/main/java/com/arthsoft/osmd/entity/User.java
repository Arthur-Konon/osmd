package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 08.09.2017.
 */
public class User extends Entity {     //table  `users`


    private String login;       //  `Login` char(50) NOT NULL,
    private String password;       //  `Password` char(50) NOT NULL,
    private int peopleId;       //  `PeopleID` int(11) DEFAULT NULL,REFERENCES `people` (`ID`)
    private boolean accessLevel; // tinyint(1) NOT NULL,


    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", peopleId=" + peopleId +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
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

    public boolean isAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(boolean accessLevel) {
        this.accessLevel = accessLevel;
    }


}

package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.User;

import java.sql.*;
import java.util.List;

/**
 * Created by arthk on 11.09.2017.
 */
public class UserDao extends AbstractDao<User> {

    @Override
    public void printEntity(List <User> entityList) {
        for (User cell:entityList ) System.out.println(cell);
    }


    @Override
    protected User getEntity() {
        return new User();
    }

    @Override
    protected String getTableName() {
        return "users";
    }


    @Override
    protected int getColumnsQty() {
        return 7;
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `users` (`Active`,`Login`,`Password`,`PeopleID`," +
                "`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `users` SET\n" +
                "`Active`= ? ,\n" +
                " `Login`= ? ,\n" +
                " `Password`= ? ,\n" +
                " `PeopleID`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=?" ;
    }

    @Override
    protected void fillEntityFromResultSet(User entity, ResultSet rs) throws SQLException {
        entity.setLogin(rs.getString("Login"));
        entity.setPassword(rs.getString("Password"));
        entity.setPeopleId(rs.getInt("PeopleId"));
    }


    @Override
    protected void fillPreparedStatementFromEntity(User entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getLogin());
        ps.setString(3, entity.getPassword());
        ps.setInt(4,entity.getPeopleId());
    }
}


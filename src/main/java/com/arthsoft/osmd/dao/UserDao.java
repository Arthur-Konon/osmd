package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.User;
import com.arthsoft.osmd.util.DbUtils;

import java.sql.*;
import java.time.LocalDate;

/**
 * Created by arthk on 11.09.2017.
 */
public class UserDao extends AbstractDao<User> {


   // public void printEntityList(List <User> entityList) {
       // for (User cell:entityList ) System.out.println(cell);
   // }


    @Override
    protected User getEntity() {
        return new User();
    }

    @Override
    protected String getTableName() {
        return "users";
    }

    @Override
    protected String getNameColumn() {
        return "Login";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `users` (`Active`,`Login`,`Password`,`PeopleID`," +
                "`AccessLevel`,`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `users` SET\n" +
                "`Active`= ? ,\n" +
                " `Login`= ? ,\n" +
                " `Password`= ? ,\n" +
                " `PeopleID`= ? ,\n" +
                " `AccessLevel`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=" ;
    }

    @Override
    protected void fillEntitySpecificFromResultSet(User entity, ResultSet rs) throws SQLException {
        entity.setLogin(rs.getString("Login"));
        entity.setPassword(rs.getString("Password"));
        entity.setPeopleId(rs.getInt("PeopleId"));
        entity.setAccessLevel(rs.getBoolean("AccessLevel"));
    }


    @Override
    protected void fillPreparedStatementFromEntity(User entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getLogin());
        ps.setString(3, entity.getPassword());
        ps.setInt(4,entity.getPeopleId());
        ps.setBoolean(5,entity.isAccessLevel());
        ps.setString(6,entity.getRemark());
        ps.setDate(7,Date.valueOf(LocalDate.now()));
    }

    public String getUserPassword(String userName){
      String password = null;
      String selectSQL = "SELECT * FROM users WHERE Login=?" ;

      try (Connection dbConnection = DbUtils.getDBConnection();
           PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )    {
            ps.setString(1,userName);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    password = rs.getString("Password");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
}


package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthk on 11.09.2017.
 */
public class UserDao {

    public static void printUsers (List<User> user){
        for (User cell:user ) System.out.println(cell);
    }

    public static List<User> getAll(){
        List <User> result = new ArrayList<>();
        String selectSQL = "SELECT * FROM users";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("Id"));
                user.setActive(rs.getBoolean("Active"));
                user.setLogin(rs.getString("Login"));
                user.setPeopleId(rs.getInt("PeopleId"));
                user.setRemark(rs.getString("Remark"));
                user.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static User getById(int id) {
        User user = new User();
        String selectSQL = "SELECT * FROM users WHERE id=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )        {
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("Id"));
                user.setActive(rs.getBoolean("Active"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("Password"));
                user.setPeopleId(rs.getInt("PeopleId"));
                user.setRemark(rs.getString("Remark"));
                user.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static boolean save (User user){
        boolean success = false;
        String insertSQL = "INSERT INTO `users` (`Active`,`Login`,`Password`,`PeopleID`," +
                "`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?)";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(insertSQL))
        {
            ps.setBoolean(1,true);
            ps.setString(2, user.getLogin());
            ps.setString(3,user.getPassword());
            ps.setInt(4,user.getPeopleId());
            ps.setString(5,user.getRemark());
            ps.setDate(6,java.sql.Date.valueOf(LocalDate.now()));
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public static boolean deleteById (int id){
        boolean success = false;
        String deleteSQL = "DELETE FROM users WHERE id=?";
        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(deleteSQL))
        {
            ps.setInt(1, id);
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean update (User user){
        boolean success = false;
        String updateSQL = "UPDATE `users` SET\n" +
                "`Active`= ? ,\n" +
                " `Login`= ? ,\n" +
                " `Password`= ? ,\n" +
                " `PeopleID`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(updateSQL))
        {
            ps.setBoolean(1,user.isActive());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setInt(4,user.getPeopleId());
            ps.setString(5,user.getRemark());
            ps.setDate(6,java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(7,user.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  success;
    }

}

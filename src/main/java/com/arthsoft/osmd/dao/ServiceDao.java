package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthk on 20.09.2017.
 */
public class ServiceDao {
    public static void printServices(List<Service> service){
        for (Service cell: service)  System.out.println(cell);
    }

    public static List<Service> getAll(){
        List <Service> result = new ArrayList<>();
        String selectSQL = "SELECT * FROM services";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("Id"));
                service.setActive(rs.getBoolean("Active"));
                service.setName(rs.getString("Name"));
                service.setPrice(rs.getFloat("Price"));
                service.setRemark(rs.getString("Remark"));
                service.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
                result.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Service getById(int id) {
        Service service = new Service();
        String selectSQL = "SELECT * FROM services WHERE id=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )        {
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                service.setId(rs.getInt("Id"));
                service.setActive(rs.getBoolean("Active"));
                service.setName(rs.getString("Name"));
                service.setPrice(rs.getFloat("Price"));
                service.setRemark(rs.getString("Remark"));
                service.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

    public static boolean save (Service service){
        boolean success = false;
        String insertSQL = "INSERT INTO `services` (`Active`,`Name`,`Price`,`DimensionID`," +
                "`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?)";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(insertSQL))
        {
            ps.setBoolean(1,true);
            ps.setString(2, service.getName());
            ps.setFloat(3,service.getPrice());
            ps.setInt(4,service.getDimensionId());
            ps.setString(5,service.getRemark());
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
        String deleteSQL = "DELETE FROM services WHERE id=?";
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


    public static boolean update (Service service){
        boolean success = false;
        String updateSQL = "UPDATE `services` SET\n" +
                "`Active`= ? ,\n" +
                " `Name`= ? ,\n" +
                " `Price`= ? ,\n" +
                " `DimensionID`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(updateSQL))
        {
            ps.setBoolean(1,service.isActive());
            ps.setString(2, service.getName());
            ps.setFloat(3, service.getPrice());
            ps.setInt(4,service.getDimensionId());
            ps.setString(5,service.getRemark());
            ps.setDate(6,java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(7,service.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  success;
    }

}

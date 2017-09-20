package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Apartment;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthk on 18.09.2017.
 */
public class ApartmentDao {

    public static void printApartments(List <Apartment> apart) {
        for (Apartment cell : apart) System.out.println(cell);
    }

    public static List <Apartment> getAll() {
        List <Apartment> result = new ArrayList<>();
        String selectSQL = "SELECT * FROM apartments";
        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Apartment apartment = new Apartment();
                apartment.setId(rs.getInt("Id"));
                apartment.setActive(rs.getBoolean("Active"));
                apartment.setHouseId(rs.getInt("HouseId"));
                apartment.setApartNum(rs.getInt("ApartNum"));
                apartment.setSupervisorId(rs.getInt("SupervisorId"));
                apartment.setTotalArea(rs.getFloat("TotalArea"));
                apartment.setHeatedArea(rs.getFloat("HeatedArea"));
                apartment.setUsefulArea(rs.getFloat("UsefulArea"));
                apartment.setPrivacy(rs.getBoolean("Privacy"));
                apartment.setCellPhone(rs.getString("CellPhone"));
                apartment.setRegTenantQty(rs.getByte("RegTenantsQty"));
                apartment.setActTenantsQty(rs.getByte("ActTenantsQty"));
                apartment.setResidentialFund(rs.getBoolean("ResidentialFund"));
                apartment.setRemark(rs.getString("Remark"));
                apartment.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
                result.add(apartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static Apartment getById(int id) {
        Apartment apartment = new Apartment();

        String selectSQL = "SELECT * FROM apartments WHERE Id=?";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)){
             ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                apartment.setId(rs.getInt("Id"));
                apartment.setActive(rs.getBoolean("Active"));
                apartment.setHouseId(rs.getInt("HouseId"));
                apartment.setApartNum(rs.getInt("ApartNum"));
                apartment.setSupervisorId(rs.getInt("SupervisorId"));
                apartment.setTotalArea(rs.getFloat("TotalArea"));
                apartment.setHeatedArea(rs.getFloat("HeatedArea"));
                apartment.setUsefulArea(rs.getFloat("UsefulArea"));
                apartment.setPrivacy(rs.getBoolean("Privacy"));
                apartment.setCellPhone(rs.getString("CellPhone"));
                apartment.setRegTenantQty(rs.getByte("RegTenantsQty"));
                apartment.setActTenantsQty(rs.getByte("ActTenantsQty"));
                apartment.setResidentialFund(rs.getBoolean("ResidentialFund"));
                apartment.setRemark(rs.getString("Remark"));
                apartment.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());

            }
        }catch(SQLException e){
                e.printStackTrace();
             }
        return apartment;
    }


    public static boolean save (Apartment apartment){
        boolean success = false;
        String insertSQL = "INSERT INTO `Apartments` (`Active`,`HouseId`,`ApartNum`,`SupervisorId`,`TotalArea`,`HeatedArea`," +
                "`UsefulArea`,`Privacy`,`CellPhone`,`RegTenantsQty`,`ActTenantsQty`,`ResidentialFund`, `Remark`,`LastUpdate`)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(insertSQL))
        {

            ps.setBoolean(1,true);
            ps.setInt(2,apartment.getHouseId());
            ps.setInt(3,apartment.getApartNum());
            ps.setInt(4,apartment.getSupervisorId());
            ps.setFloat(5,apartment.getTotalArea());
            ps.setFloat(6,apartment.getHeatedArea());
            ps.setFloat(7,apartment.getUsefulArea());
            ps.setBoolean(8,apartment.isPrivacy());
            ps.setString(9,apartment.getCellPhone());
            ps.setByte(10,apartment.getRegTenantQty());
            ps.setByte(11,apartment.getActTenantsQty());
            ps.setBoolean(12,apartment.isResidentialFund());
            ps.setString(13,apartment.getRemark());
            ps.setDate(14,java.sql.Date.valueOf(LocalDate.now()));
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public static boolean deleteById (int id){
        boolean success = false;
        String deleteSQL = "DELETE FROM apartments WHERE id=?";
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


    public static boolean update (Apartment apartment){
        boolean success = false;
        String updateSQL = "UPDATE `apartments` SET\n" +
                "`Active`= ? ,\n" +
                " `HouseID` = ? ,\n" +
                " `ApartNum`= ? ,\n" +
                " `SupervisorId` = ? ,\n" +
                " `TotalArea`= ? ,\n" +
                " `HeatedArea`= ? ,\n" +
                " `UsefulArea`= ? ,\n" +
                " `Privacy`= ? ,\n" +
                " `CellPhone`= ? ,\n" +
                " `RegTenantsQty`= ? ,\n" +
                " `ActTenantsQty`= ? ,\n" +
                " `ResidentialFund`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(updateSQL))
        {
            ps.setBoolean(1,apartment.isActive());
            ps.setInt(2,apartment.getHouseId());
            ps.setInt(3,apartment.getApartNum());
            ps.setInt(4,apartment.getSupervisorId());
            ps.setFloat(5,apartment.getTotalArea());
            ps.setFloat(6,apartment.getHeatedArea());
            ps.setFloat(7,apartment.getUsefulArea());
            ps.setBoolean(8,apartment.isPrivacy());
            ps.setString(9,apartment.getCellPhone());
            ps.setByte(10,apartment.getRegTenantQty());
            ps.setByte(11,apartment.getActTenantsQty());
            ps.setBoolean(12,apartment.isResidentialFund());
            ps.setString(13,apartment.getRemark());
            ps.setDate(14,java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(15,apartment.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  success;
    }
}
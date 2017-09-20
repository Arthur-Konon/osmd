package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Benefit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthk on 19.09.2017.
 */
public class BenefitDao {

    public static void printBenefits (List<Benefit> benefit){
        for (Benefit cell: benefit) System.out.println(cell);
    }

    public static List<Benefit> getAll (){
        List<Benefit> result = new ArrayList <>();

        String selectSQL = "SELECT * FROM benefits";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                Benefit benefit = new Benefit();
                benefit.setId(rs.getInt("Id"));
                benefit.setActive(rs.getBoolean("Active"));
                benefit.setTypeId(rs.getInt("TypeId"));
                benefit.setPeopleId(rs.getInt("PeopleId"));
                benefit.setBenefitPercent(rs.getFloat("BenefitPercent"));
                benefit.setServiceId(rs.getInt("ServiceId"));
                benefit.setName(rs.getString("Name"));
                benefit.setRemark(rs.getString("Remark"));
                benefit.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
                result.add(benefit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Benefit getById(int id) {
        Benefit benefit = new Benefit();
        String selectSQL = "SELECT * FROM benefits WHERE id=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )        {
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                benefit.setId(rs.getInt("Id"));
                benefit.setActive(rs.getBoolean("Active"));
                benefit.setTypeId(rs.getInt("TypeId"));
                benefit.setPeopleId(rs.getInt("PeopleId"));
                benefit.setBenefitPercent(rs.getFloat("BenefitPercent"));
                benefit.setServiceId(rs.getInt("ServiceId"));
                benefit.setName(rs.getString("Name"));
                benefit.setRemark(rs.getString("Remark"));
                benefit.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return benefit;
    }

    public static boolean save (Benefit benefit){
        boolean success = false;
        String insertSQL =
                //"INSERT INTO `benefits` (`Active`,`TypeID`,`PeopleID`,`BenefitPercent`," +
//"`ServiceID`,`Name`,`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?,?,?')";


                "INSERT INTO `benefits` (`Active`,`TypeID`,`PeopleID`,`BenefitPercent`," +
               "`ServiceID`,`Name`,`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(insertSQL))
        {
            ps.setBoolean(1,true);
            ps.setInt(2, benefit.getTypeId());
            ps.setInt(3,benefit.getPeopleId());
            ps.setFloat(4,benefit.getBenefitPercent());
            ps.setInt(5,benefit.getServiceId());
            ps.setString(6,benefit.getName());
            ps.setString(7,benefit.getRemark());
            ps.setDate(8,java.sql.Date.valueOf(LocalDate.now()));
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean deleteById (int id){
        boolean success = false;
        String deleteSQL = "DELETE FROM benefits WHERE id=?";
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

    public static boolean update (Benefit benefit){
        boolean success = false;
        String updateSQL = "UPDATE `benefits` SET\n" +
                "`Active`= ? ,\n" +
                " `TypeId`= ? ,\n" +
                " `PeopleID`= ? ,\n" +
                " `BenefitPercent`= ? ,\n" +
                " `ServiceID`= ? ,\n" +
                " `Name`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(updateSQL))
        {
            ps.setBoolean(1,benefit.isActive());
            ps.setInt(2, benefit.getTypeId());
            ps.setInt(3,benefit.getPeopleId());
            ps.setFloat(4,benefit.getBenefitPercent());
            ps.setInt(5,benefit.getServiceId());
            ps.setString(6,benefit.getName());
            ps.setString(7,benefit.getRemark());
            ps.setDate(8,java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(9,benefit.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  success;
    }






}

package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.BenefitsType;

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
public class BenefitsTypeDao {

    public static void printBenefitsTypes (List<BenefitsType> bt){
        for (BenefitsType cell:bt ) System.out.println(cell);
    }

    public static List<BenefitsType> getAll(){
        List <BenefitsType> result = new ArrayList<>();
        String selectSQL = "SELECT * FROM benefitstypes";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                BenefitsType bt = new BenefitsType();
                bt.setId(rs.getInt("Id"));
                bt.setActive(rs.getBoolean("Active"));
                bt.setName(rs.getString("Name"));
                bt.setRemark(rs.getString("Remark"));
                bt.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
                result.add(bt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static BenefitsType getById(int id) {
        BenefitsType bt = new BenefitsType();
        String selectSQL = "SELECT * FROM benefitstypes WHERE id=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )        {
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bt.setId(rs.getInt("Id"));
                bt.setActive(rs.getBoolean("Active"));
                bt.setName(rs.getString("Name"));
                bt.setRemark(rs.getString("Remark"));
                bt.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bt;
    }
    public static boolean save (BenefitsType bt){
        boolean success = false;
        String insertSQL = "INSERT INTO `benefitstypes` (`Active`,`Name`," +
                "`Remark`,`LastUpdate`) VALUES (?,?,?,?)";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(insertSQL))
        {
            ps.setBoolean(1,true);
            ps.setString(2, bt.getName());
            ps.setString(3,bt.getRemark());
            ps.setDate(4,java.sql.Date.valueOf(LocalDate.now()));
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public static boolean deleteById (int id){
        boolean success = false;
        String deleteSQL = "DELETE FROM benefitstypes WHERE id=?";
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

    public static boolean update (BenefitsType bt){
        boolean success = false;
        String updateSQL = "UPDATE `benefitstypes` SET\n" +
                "`Active`= ? ,\n" +
                " `Name`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(updateSQL))
        {
            ps.setBoolean(1,bt.isActive());
            ps.setString(2, bt.getName());
            ps.setString(3,bt.getRemark());
            ps.setDate(4,java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(5,bt.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  success;
    }
}

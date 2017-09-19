package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthk on 12.09.2017.
 */
public class HouseDao {

    public static void printHouses(List <House> house) {
        for (House cell : house) System.out.println(cell);
    }

    public static List <House> getAll() {
        List <House> result = new ArrayList();
        String selectSQL = "SELECT * FROM houses";
        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                House house = new House();
                house.setId(rs.getInt("Id"));
                house.setActive(rs.getBoolean("Active"));
                house.setAddress(rs.getString("Address"));
                house.setYear(rs.getInt("Year"));
                house.setQtyOfStoreys(rs.getInt("QtyOfStoreys"));
                house.setQtyOfAllApart(rs.getInt("QtyOfAllApart"));
                house.setTotalArea(rs.getFloat("TotalArea"));
                house.setAreaOfAllApart(rs.getFloat("AreaOfAllApart"));
                house.setRemark(rs.getString("Remark"));
                house.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
                result.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static House getById(int id) {
        House house = new House();
        String selectSQL = "SELECT * FROM houses WHERE id=?" ;


        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )        {
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    house.setId(rs.getInt("Id"));
                    house.setActive(rs.getBoolean("Active"));
                    house.setAddress(rs.getString("Address"));
                    house.setYear(rs.getInt("Year"));
                    house.setQtyOfStoreys(rs.getInt("QtyOfStoreys"));
                    house.setQtyOfAllApart(rs.getInt("QtyOfAllApart"));
                    house.setTotalArea(rs.getFloat("TotalArea"));
                    house.setAreaOfAllApart(rs.getFloat("AreaOfAllApart"));
                    house.setRemark(rs.getString("Remark"));
                    house.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return house;
    }


    public static boolean save (House house){
        boolean success = false;
        String insertSQL = "INSERT INTO `houses` (`Active`,`Address`,`Year`,`QtyOfStoreys`,`QtyOfAllApart`,`TotalArea`," +
                "`AreaOfAllApart`,`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(insertSQL))
        {
        ps.setBoolean(1,true);
        ps.setString(2, house.getAddress());
        ps.setInt(3,house.getYear());
        ps.setInt(4,house.getQtyOfStoreys());
        ps.setInt(5,house.getQtyOfAllApart());
        ps.setFloat(6,house.getTotalArea());
        ps.setFloat(7,house.getAreaOfAllApart());
        ps.setString(8,house.getRemark());
        ps.setDate(9,java.sql.Date.valueOf(LocalDate.now()));
        ps.execute();
        success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public static boolean deleteById (int id){
        boolean success = false;
        String deleteSQL = "DELETE FROM houses WHERE id=?";
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

public static boolean update (House house){
    boolean success = false;
    int id = house.getId();
    String updateSQL = "UPDATE `houses` SET\n" +
            "`Active`= ? ,\n" +
            " `Address` = ? ,\n" +
            " `Year`= ? ,\n" +
            " `QtyOfStoreys` = ? ,\n" +
            " `QtyOfAllApart`= ? ,\n" +
            " `TotalArea`= ? ,\n" +
            " `AreaOfAllApart` = ? ,\n" +
            " `Remark`= ? ,\n" +
            " `LastUpdate` = ? \n" +
            "WHERE  `Id`=?" ;


    try (Connection dbConnection = DbUtils.getDBConnection();
         PreparedStatement ps = dbConnection.prepareStatement(updateSQL))
    {
        ps.setBoolean(1,house.isActive());
        ps.setString(2, house.getAddress());
        ps.setInt(3,house.getYear());
        ps.setInt(4,house.getQtyOfStoreys());
        ps.setInt(5,house.getQtyOfAllApart());
        ps.setFloat(6,house.getTotalArea());
        ps.setFloat(7,house.getAreaOfAllApart());
        ps.setString(8,house.getRemark());
        ps.setDate(9,java.sql.Date.valueOf(LocalDate.now()));
        ps.setInt(10,id);
        ps.execute();
        success = true;

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return  success;
}

}

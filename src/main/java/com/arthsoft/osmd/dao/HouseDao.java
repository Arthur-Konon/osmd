package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Entity;
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
public class HouseDao extends AbstractDao<House> {

    @Override
    public void printEntityList(List<House> houseList) {
        for (House cell : houseList) System.out.println(cell);
    }

    @Override
    protected House getEntity() {
        return new House();
    }

    @Override
    protected String getTableName() {
        return "houses";
    }


    @Override
    protected String getInsertScript() {
        return "INSERT INTO `houses` (`Active`,`Address`,`Year`,`QtyOfStoreys`,`QtyOfAllApart`,`TotalArea`," +
                "`AreaOfAllApart`,`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `houses` SET\n" +
                "`Active`= ? ,\n" +
                " `Address` = ? ,\n" +
                " `Year`= ? ,\n" +
                " `QtyOfStoreys` = ? ,\n" +
                " `QtyOfAllApart`= ? ,\n" +
                " `TotalArea`= ? ,\n" +
                " `AreaOfAllApart` = ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=" ;
    }

    @Override
    protected void fillEntitySpecificFromResultSet(House entity, ResultSet rs) throws SQLException {
        entity.setAddress(rs.getString("Address"));
        entity.setYear(rs.getInt("Year"));
        entity.setQtyOfStoreys(rs.getInt("QtyOfStoreys"));
        entity.setQtyOfAllApart(rs.getInt("QtyOfAllApart"));
        entity.setTotalArea(rs.getFloat("TotalArea"));
        entity.setAreaOfAllApart(rs.getFloat("AreaOfAllApart"));

    }

    @Override
    protected void fillPreparedStatementFromEntity(House entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getAddress());
        ps.setInt(3,entity.getYear());
        ps.setInt(4,entity.getQtyOfStoreys());
        ps.setInt(5,entity.getQtyOfAllApart());
        ps.setFloat(6,entity.getTotalArea());
        ps.setFloat(7,entity.getAreaOfAllApart());
        ps.setString(8,entity.getRemark());
        ps.setDate(9,java.sql.Date.valueOf(LocalDate.now()));
    }



}

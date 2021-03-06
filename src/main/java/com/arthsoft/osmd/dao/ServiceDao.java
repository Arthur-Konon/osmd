package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by arthk on 20.09.2017.
 */
public class ServiceDao extends AbstractDao <Service> {

    @Override
    protected Service getEntity() {
        return new Service();
    }

    @Override
    protected String getTableName() {
        return "services";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `services` (`Active`,`Name`,`Price`,`DimensionID`," +
                "`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `services` SET\n" +
                "`Active`= ? ,\n" +
                " `Name`= ? ,\n" +
                " `Price`= ? ,\n" +
                " `DimensionID`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=";
    }

    @Override
    protected void fillEntitySpecificFromResultSet(Service entity, ResultSet rs) throws SQLException {
        entity.setName(rs.getString("Name"));
        entity.setPrice(rs.getFloat("Price"));
        entity.setDimensionId(rs.getInt("DimensionID"));
    }

    @Override
    protected void fillPreparedStatementFromEntity(Service entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getName());
        ps.setFloat(3, entity.getPrice());
        ps.setInt(4, entity.getDimensionId());
        ps.setString(5, entity.getRemark());
        ps.setDate(6, Date.valueOf(LocalDate.now()));
    }


}

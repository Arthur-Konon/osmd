package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Dimension;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by arthk on 26.09.2017.
 */
public class DimensionDao extends AbstractDao <Dimension> {

    @Override
    protected Dimension getEntity() {
        return new Dimension();
    }

    @Override
    protected String getTableName() {
        return "dimensions";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `dimensions` (`Active`,`Name`," +
                "`Remark`,`LastUpdate`) VALUES (?,?,?,?)";

    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `dimensions` SET\n" +
                "`Active`= ? ,\n" +
                " `Name`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=";
    }

    @Override
    protected void fillEntitySpecificFromResultSet(Dimension entity, ResultSet rs) throws SQLException {
        entity.setName(rs.getString("Name"));
    }

    @Override
    protected void fillPreparedStatementFromEntity(Dimension entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getName());
        ps.setString(3, entity.getRemark());
        ps.setDate(4, Date.valueOf(LocalDate.now()));
    }

}

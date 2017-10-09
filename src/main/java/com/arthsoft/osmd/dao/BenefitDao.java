package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Benefit;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by arthk on 19.09.2017.
 */
public class BenefitDao extends AbstractDao <Benefit> {

    @Override
    protected Benefit getEntity() {
        return new Benefit();
    }

    @Override
    protected String getTableName() {
        return "benefits";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `benefits` (`Active`,`TypeID`,`PeopleID`,`BenefitPercent`," +
                "`ServiceID`,`Name`,`Remark`,`LastUpdate`) VALUES (?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `benefits` SET\n" +
                "`Active`= ? ,\n" +
                " `TypeId`= ? ,\n" +
                " `PeopleID`= ? ,\n" +
                " `BenefitPercent`= ? ,\n" +
                " `ServiceID`= ? ,\n" +
                " `Name`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=";
    }

    @Override
    protected void fillEntitySpecificFromResultSet(Benefit entity, ResultSet rs) throws SQLException {
        entity.setActive(rs.getBoolean("Active"));
        entity.setTypeId(rs.getInt("TypeId"));
        entity.setPeopleId(rs.getInt("PeopleId"));
        entity.setBenefitPercent(rs.getFloat("BenefitPercent"));
        entity.setServiceId(rs.getInt("ServiceId"));
        entity.setName(rs.getString("Name"));
    }

    @Override
    protected void fillPreparedStatementFromEntity(Benefit entity, PreparedStatement ps) throws SQLException {
        ps.setInt(2, entity.getTypeId());
        ps.setInt(3, entity.getPeopleId());
        ps.setFloat(4, entity.getBenefitPercent());
        ps.setInt(5, entity.getServiceId());
        ps.setString(6, entity.getName());
        ps.setString(7, entity.getRemark());
        ps.setDate(8, Date.valueOf(LocalDate.now()));
    }
}

package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Owner;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by arthk on 26.09.2017.
 */
public class OwnerDao extends AbstractDao<Owner> {

    @Override
    protected Owner getEntity() {
        return new Owner();
    }

    @Override
    protected String getTableName() {
        return "owners";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `owners` (`Active`,`PeopleID`,`OwnApartID`,`OwnPart`,`OwnDocID`," +
                "`Senior`,`Remark`,`LastUpdate`) VALUES\n" +
                " (?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `owners` SET\n" +
                "  `Active`=?,\n" +
                "  `PeopleID`=?,\n" +
                "  `OwnApartID`=?,\n" +
                "  `OwnPart`=?,\n" +
                "  `OwnDocID`=?,\n" +
                "  `Senior`=?,\n" +
                "  `Remark`=?,\n" +
                "  `LastUpdate`=?\n" +
                "WHERE `ID`=";
    }

    @Override
    protected void fillEntitySpecificFromResultSet(Owner entity, ResultSet rs) throws SQLException {
        entity.setPeopleId(rs.getInt("PeopleID"));
        entity.setOwnApartId(rs.getInt("OwnApartID"));
        entity.setOwnPart(rs.getInt("OwnPart"));
        entity.setOwnDocId(rs.getInt("OwnDocID"));
        entity.setSenior(rs.getBoolean("Senior"));
    }

    @Override
    protected void fillPreparedStatementFromEntity(Owner entity, PreparedStatement ps) throws SQLException {
        ps.setInt(2, entity.getPeopleId());
        ps.setInt(3, entity.getOwnApartId());
        ps.setInt(4, entity.getOwnPart());
        ps.setInt(5, entity.getOwnDocId());
        ps.setBoolean(6,entity.isSenior());
        ps.setString(7,entity.getRemark());
        ps.setDate(8, Date.valueOf(LocalDate.now()));
    }
}

package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.OwnDocument;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by arthk on 26.09.2017.
 */
public class OwnDocumentDao extends AbstractDao<OwnDocument>{
    @Override
    public void printEntityList(List<OwnDocument> entityList) {
        for (OwnDocument cell :entityList) System.out.println(cell);
    }

    @Override
    protected OwnDocument getEntity() {
        return new OwnDocument();
    }

    @Override
    protected String getTableName() {
        return "owndocuments";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `owndocuments` \n" +
                " (`Active`,`Name`,`Number`,`StartDate`,`Remark`,`LastUpdate`)\n" +
                "VALUES (?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `owndocuments` SET\n" +
                "  `Active`=?,\n" +
                "  `Name`=?,\n" +
                "  `Number`=?,\n" +
                "  `StartDate`=?,\n" +
                "  `Remark`=?,\n" +
                "  `LastUpdate`=?\n" +
                " WHERE `ID`=";
    }

    @Override
    protected void fillEntityFromResultSet(OwnDocument entity, ResultSet rs) throws SQLException {
        entity.setName(rs.getString("Name"));
        entity.setNumber(rs.getString("Number"));

        if (rs.getDate("StartDate") == null) entity.setStartDate(null);
        else entity.setStartDate(rs.getDate("StartDate").toLocalDate());
    }

    @Override
    protected void fillPreparedStatementFromEntity(OwnDocument entity, PreparedStatement ps) throws SQLException {
        ps.setString(2,entity.getName());
        ps.setString(3,entity.getNumber());

        if(entity.getStartDate() == null) ps.setDate(4,null);
        else ps.setDate(4,java.sql.Date.valueOf(entity.getStartDate()));

        ps.setString(5,entity.getRemark());
        ps.setDate(6, Date.valueOf(LocalDate.now()));

    }
}

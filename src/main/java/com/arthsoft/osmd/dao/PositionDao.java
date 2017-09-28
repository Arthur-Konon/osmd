package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Position;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by arthk on 27.09.2017.
 */
public class PositionDao extends AbstractDao<Position> {
    @Override
    public void printEntityList(List<Position> entityList) {
        for (Position cell: entityList) System.out.println(cell);
    }

    @Override
    protected Position getEntity() {
        return new Position();
    }

    @Override
    protected String getTableName() {
        return "positions";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `positions`\n" +
                " (`Active`,`Name`,`Paid`,`Stated`,`Remark`,`LastUpdate`) \n" +
                "VALUES  (?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `positions` SET\n" +
                " `Active`=?,\n" +
                " `Name`=?,\n" +
                " `Paid`=?,\n" +
                " `Stated`=?,\n" +
                " `Remark`=?,\n" +
                " `LastUpdate`=?\n" +
                " WHERE `ID`=";

    }

    @Override
    protected void fillEntitySpecificFromResultSet(Position entity, ResultSet rs) throws SQLException {
        entity.setName(rs.getString("Name"));
        entity.setPaid(rs.getBoolean("Paid"));
        entity.setStated(rs.getBoolean("Stated"));
    }

    @Override
    protected void fillPreparedStatementFromEntity(Position entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getName());
        ps.setBoolean(3,entity.isPaid());
        ps.setBoolean(4,entity.isStated());
        ps.setString(5,entity.getRemark());
        ps.setDate(6, Date.valueOf(LocalDate.now()));
    }
}

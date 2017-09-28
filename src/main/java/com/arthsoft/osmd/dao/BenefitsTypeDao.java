package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.BenefitsType;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by arthk on 20.09.2017.
 */
public class BenefitsTypeDao extends AbstractDao<BenefitsType>{

    @Override
    public void printEntityList(List <BenefitsType> entityList) {
        for (BenefitsType cell: entityList) System.out.println(cell);
    }

    @Override
    protected BenefitsType getEntity() {
        return new BenefitsType();
    }

    @Override
    protected String getTableName() {
        return "benefitstypes";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `benefitstypes` (`Active`,`Name`," +
                "`Remark`,`LastUpdate`) VALUES (?,?,?,?)";

    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `benefitstypes` SET\n" +
                "`Active`= ? ,\n" +
                " `Name`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=" ;
    }

    @Override
    protected void fillEntitySpecificFromResultSet(BenefitsType entity, ResultSet rs) throws SQLException {
        entity.setName(rs.getString("Name"));
    }

    @Override
    protected void fillPreparedStatementFromEntity(BenefitsType entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getName());
        ps.setString(3,entity.getRemark());
        ps.setDate(4, Date.valueOf(LocalDate.now()));
    }


}

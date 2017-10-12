package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Apartment;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by arthk on 18.09.2017.
 */
public class ApartmentDao extends AbstractDao <Apartment> {


    @Override
    protected Apartment getEntity() {
        return new Apartment();
    }

    @Override
    protected String getTableName() {
        return "apartments";
    }

    /*
        @Override
        protected String getGuiAllScript() {
            return "SELECT\n" +
                    "a.ID,\n" +
                    "a.Active,\n" +
                    "h.Address,\n" +
                    "a.ApartNum,\n" +
                    " concat (p.FirstName ,' ' , LEFT (p.LastName,1), '. ',LEFT (p.Patronymic,1), '.') as Supervisor,\n" +
                    "a.TotalArea,\n" +
                    "a.HeatedArea,\n" +
                    "a.UsefulArea,\n" +
                    "a.Privacy,\n" +
                    "a.CellPhone,\n" +
                    "a.RegTenantsQty,\n" +
                    "a.ActTenantsQty,\n" +
                    "a.ResidentialFund,\n" +
                    "a.Remark,\n" +
                    "a.LastUpdate\n" +
                    "FROM apartments  a\n" +
                    "join houses  h on a.HouseId = h.ID\n" +
                    "join people p on a.SupervisorId = p.ID";
        }
    */
    @Override
    protected String getInsertScript() {
        return "INSERT INTO `DomainDaoApartment` (`Active`,`HouseId`,`ApartNum`,`SupervisorId`,`TotalArea`,`HeatedArea`," +
                "`UsefulArea`,`Privacy`,`CellPhone`,`RegTenantsQty`,`ActTenantsQty`,`ResidentialFund`, `Remark`,`LastUpdate`)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `apartments` SET\n" +
                "`Active`= ? ,\n" +
                " `HouseID` = ? ,\n" +
                " `ApartNum`= ? ,\n" +
                " `SupervisorId` = ? ,\n" +
                " `TotalArea`= ? ,\n" +
                " `HeatedArea`= ? ,\n" +
                " `UsefulArea`= ? ,\n" +
                " `Privacy`= ? ,\n" +
                " `CellPhone`= ? ,\n" +
                " `RegTenantsQty`= ? ,\n" +
                " `ActTenantsQty`= ? ,\n" +
                " `ResidentialFund`= ? ,\n" +
                " `Remark`= ? ,\n" +
                " `LastUpdate` = ? \n" +
                "WHERE  `Id`=";
    }

    @Override
    protected void fillEntitySpecificFromResultSet(Apartment entity, ResultSet rs) throws SQLException {
        entity.setHouseId(rs.getInt("HouseId"));
        entity.setApartNum(rs.getInt("ApartNum"));
        entity.setSupervisorId(rs.getInt("SupervisorId"));
        entity.setTotalArea(rs.getFloat("TotalArea"));
        entity.setHeatedArea(rs.getFloat("HeatedArea"));
        entity.setUsefulArea(rs.getFloat("UsefulArea"));
        entity.setPrivacy(rs.getBoolean("Privacy"));
        entity.setCellPhone(rs.getString("CellPhone"));
        entity.setRegTenantQty(rs.getByte("RegTenantsQty"));
        entity.setActTenantsQty(rs.getByte("ActTenantsQty"));
        entity.setResidentialFund(rs.getBoolean("ResidentialFund"));
    }

    /*
        protected void fillGuiEntitySpecificFromResultSet(Apartment entity, ResultSet rs) throws SQLException {
            entity.setGuiAddress(rs.getString("Address"));
            entity.setApartNum(rs.getInt("ApartNum"));
            entity.setGuiSupervisor(rs.getString("Supervisor"));
            entity.setTotalArea(rs.getFloat("TotalArea"));
            entity.setHeatedArea(rs.getFloat("HeatedArea"));
            entity.setUsefulArea(rs.getFloat("UsefulArea"));
            entity.setPrivacy(rs.getBoolean("Privacy"));
            entity.setCellPhone(rs.getString("CellPhone"));
            entity.setRegTenantQty(rs.getByte("RegTenantsQty"));
            entity.setActTenantsQty(rs.getByte("ActTenantsQty"));
            entity.setResidentialFund(rs.getBoolean("ResidentialFund"));
        }

    */
    @Override
    protected void fillPreparedStatementFromEntity(Apartment entity, PreparedStatement ps) throws SQLException {
        ps.setInt(2, entity.getHouseId());
        ps.setInt(3, entity.getApartNum());
        ps.setInt(4, entity.getSupervisorId());
        ps.setFloat(5, entity.getTotalArea());
        ps.setFloat(6, entity.getHeatedArea());
        ps.setFloat(7, entity.getUsefulArea());
        ps.setBoolean(8, entity.isPrivacy());
        ps.setString(9, entity.getCellPhone());
        ps.setByte(10, entity.getRegTenantQty());
        ps.setByte(11, entity.getActTenantsQty());
        ps.setBoolean(12, entity.isResidentialFund());
        ps.setString(13, entity.getRemark());
        ps.setDate(14, Date.valueOf(LocalDate.now()));
    }
}

package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.CompanyInfo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by arthk on 26.09.2017.
 */
public class CompanyInfoDao extends AbstractDao <CompanyInfo> {

    @Override
    protected CompanyInfo getEntity() {
        return new CompanyInfo();
    }

    @Override
    protected String getTableName() {
        return "companyinfo";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `companyinfo` \n" +
                "(  `Active`, `Name`, `Address`, `Phone`, `Email`, `ManagerID`, `TaxIdNum`, \n" +
                "  `TaxNum`, `BankCode`, `BankName` ,`AccountNum`, `Remark`, `LastUpdate`)\n" +
                "  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)\n";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `companyinfo` SET\n" +
                " `Active`=?,\n" +
                " `Name`=?,\n" +
                " `Address`=?,\n" +
                " `Phone`=?,\n" +
                " `Email`=?,\n" +
                " `ManagerID`=?,\n" +
                " `TaxIdNum`=?,\n" +
                " `TaxNum`=?,\n" +
                " `BankCode`=?,\n" +
                " `BankName`=?,\n" +
                " `AccountNum`=?,\n" +
                " `Remark`=?,\n" +
                " `LastUpdate`=?\n" +
                "WHERE  `Id`=";
    }

    @Override
    protected void fillEntitySpecificFromResultSet(CompanyInfo entity, ResultSet rs) throws SQLException {
        entity.setName(rs.getString("Name"));
        entity.setAddress(rs.getString("Address"));
        entity.setPhone(rs.getString("Phone"));
        entity.setEmail(rs.getString("Email"));
        entity.setManagerId(rs.getInt("ManagerId"));
        entity.setTaxIdNum(rs.getString("TaxIdNum"));
        entity.setTaxNum(rs.getString("TaxNum"));
        entity.setBankCode(rs.getString("BankCode"));
        entity.setBankName(rs.getString("BankName"));
        entity.setAccountNum(rs.getString("AccountNum"));
    }


    @Override
    protected void fillPreparedStatementFromEntity(CompanyInfo entity, PreparedStatement ps) throws SQLException {
        ps.setString(2, entity.getName());
        ps.setString(3, entity.getAddress());
        ps.setString(4, entity.getPhone());
        ps.setString(5, entity.getEmail());
        ps.setInt(6, entity.getManagerId());
        ps.setString(7, entity.getTaxIdNum());
        ps.setString(8, entity.getTaxNum());
        ps.setString(9, entity.getBankCode());
        ps.setString(10, entity.getBankName());
        ps.setString(11, entity.getAccountNum());
        ps.setString(12, entity.getRemark());
        ps.setDate(13, Date.valueOf(LocalDate.now()));
    }
}

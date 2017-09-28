package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Person;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by arthk on 27.09.2017.
 */
public class PersonDao extends AbstractDao<Person>{
    @Override
    public void printEntityList(List<Person> entityList) {
        for (Person cell: entityList) System.out.println(cell);
    }

    @Override
    protected Person getEntity() {
        return new Person();
    }

    @Override
    protected String getTableName() {
        return "people";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO `people` (`Active`,`FirstName`,`LastName`,`Patronymic`,`ResidApartID`,`RegApartID`,\n" +
                "`BirthDate`,`Phone`,`TaxNum`,`PassportSeries`,`PassportNum`,`IssuedBy`,`IssuedDate`,`Remark`,`LastUpdate`)\n" +
                " VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE `people` SET\n" +
                " `Active`=?,\n" +
                " `FirstName`=?,\n" +
                " `LastName`=?,\n" +
                " `Patronymic`=?,\n" +
                " `ResidApartID`=?,\n" +
                " `RegApartID`=?,\n" +
                "`BirthDate`=?,\n" +
                "`Phone`=?,\n" +
                "`TaxNum`=?,\n" +
                "`PassportSeries`=?,\n" +
                "`PassportNum`=?,\n" +
                "`IssuedBy`=?,\n" +
                "`IssuedDate`=?,\n" +
                "`Remark`=?,\n" +
                "`LastUpdate`=?\n" +
                "WHERE `ID`=";
    }

    @Override
    protected void fillEntitySpecificFromResultSet(Person entity, ResultSet rs) throws SQLException {
        entity.setFirstName(rs.getString("FirstName"));
        entity.setLastName(rs.getString("LastName"));
        entity.setPatronymic(rs.getString("Patronymic"));
        entity.setResidApartId(rs.getInt("ResidApartID"));
        entity.setRegApartId(rs.getInt("RegApartID"));

        if (rs.getDate("BirthDate") == null) entity.setBirthDate(null);
        else entity.setBirthDate(rs.getDate("BirthDate").toLocalDate());

        entity.setPhone(rs.getString("Phone"));
        entity.setTaxNum(rs.getString("TaxNum"));
        entity.setPassportSeries(rs.getString("PassportSeries"));
        entity.setPassportNum(rs.getString("PassportNum"));
        entity.setIssuedBy(rs.getString("IssuedBy"));

        if (rs.getDate("IssuedDate") == null) entity.setIssuedDate(null);
        else entity.setIssuedDate(rs.getDate("IssuedDate").toLocalDate());
    }

    @Override
    protected void fillPreparedStatementFromEntity(Person entity, PreparedStatement ps) throws SQLException {
        ps.setString(2,entity.getFirstName());
        ps.setString(3,entity.getLastName());
        ps.setString(4,entity.getPatronymic());
        ps.setInt(5,entity.getResidApartId());
        ps.setInt(6,entity.getRegApartId());

        if(entity.getBirthDate() == null) ps.setDate(7,null);
        else ps.setDate(7,Date.valueOf(entity.getBirthDate()));

        ps.setString(8,entity.getPhone());
        ps.setString(9,entity.getTaxNum());
        ps.setString(10,entity.getPassportSeries());
        ps.setString(11,entity.getPassportNum());
        ps.setString(12,entity.getIssuedBy());

        if(entity.getIssuedDate() == null) ps.setDate(13,null);
        else ps.setDate(13,Date.valueOf(entity.getIssuedDate()));

        ps.setString(14,entity.getRemark());
        ps.setDate(15, Date.valueOf(LocalDate.now()));
    }
}


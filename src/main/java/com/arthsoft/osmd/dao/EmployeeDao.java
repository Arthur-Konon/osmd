package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Employee;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by arthk on 26.09.2017.
 */
public class EmployeeDao extends AbstractDao<Employee> {
    @Override
    public void printEntityList(List<Employee> entityList) {
        for (Employee cell:entityList) System.out.println(cell);
    }

    @Override
    protected Employee getEntity() {
        return new Employee();
    }

    @Override
    protected String getTableName() {
        return "employees";
    }

    @Override
    protected String getInsertScript() {
        return "INSERT INTO  `employees` \n" +
                "  (`Active`,`PeopleID`,`PositionID`,`HireDate`,`FireDate`,\n" +
                "  `Salary`,`Remark`,`LastUpdate`)\n" +
                "VALUES (?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getUpdateScript() {
        return "UPDATE  `employees` SET\n" +
                "  `Active`=?,\n" +
                "  `PeopleID`=?,\n" +
                "  `PositionID`=?,\n" +
                "  `HireDate`=?,\n" +
                "  `FireDate`=?,\n" +
                "  `Salary`=?,\n" +
                "  `Remark`=?,\n" +
                "  `LastUpdate`=?\n" +
                "  WHERE ID=";
    }

    @Override
    protected void fillEntityFromResultSet(Employee entity, ResultSet rs) throws SQLException {
        entity.setPeopleId(rs.getInt("PeopleID"));
        entity.setPositionId(rs.getInt("PositionID"));

        if (rs.getDate("HireDate") == null) entity.setHireDate(null);
        else entity.setHireDate(rs.getDate("HireDate").toLocalDate());

        if (rs.getDate("FireDate") == null) entity.setFireDate(null);
        else entity.setFireDate(rs.getDate("FireDate").toLocalDate());

        entity.setSalary(rs.getFloat("Salary"));
    }

    @Override
    protected void fillPreparedStatementFromEntity(Employee entity, PreparedStatement ps) throws SQLException {
        ps.setInt(2,entity.getPeopleId());
        ps.setInt(3,entity.getPositionId());

        if(entity.getHireDate() == null) ps.setDate(4,null);
        else ps.setDate(4,java.sql.Date.valueOf(entity.getHireDate()));

        if(entity.getFireDate() == null) ps.setDate(5,null);
        else ps.setDate(5,java.sql.Date.valueOf(entity.getFireDate()));

        ps.setFloat(6,entity.getSalary());
        ps.setString(7,entity.getRemark());
        ps.setDate(8, Date.valueOf(LocalDate.now()));
    }
}

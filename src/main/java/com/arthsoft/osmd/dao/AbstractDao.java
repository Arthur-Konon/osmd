package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Entity;
import com.arthsoft.osmd.util.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthk on 21.09.2017.
 */
public abstract class AbstractDao<T extends Entity> {


    public  void printEntityList(List <T> entityList){

        for (T cell: entityList) System.out.println(cell);
    }

    protected abstract T getEntity();
    protected abstract  String getTableName ();
    protected abstract  String getInsertScript ();
    protected abstract  String getUpdateScript ();
    protected abstract void fillEntitySpecificFromResultSet(T entity, ResultSet rs) throws SQLException;
    protected abstract void fillPreparedStatementFromEntity(T entity,PreparedStatement ps) throws SQLException;

    protected String getNameColumn(){
        return "";
    }


    public  List<T> getAll(){
        List <T> result = new ArrayList<>();
        String selectSQL = "SELECT * FROM " + getTableName();

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                T entity = getEntity();
                fillEntity(rs, entity);
                result.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public  ResultSet getAllAsRusultSet() throws SQLException {

        String selectSQL = "SELECT * FROM " + getTableName();
        Connection dbConnection = DbUtils.getDBConnection();
        PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
        return ps.executeQuery();
    }

    private void fillEntity(ResultSet rs, T entity) throws SQLException {
        entity.setId(rs.getInt("Id"));
        entity.setActive(rs.getBoolean("Active"));
        entity.setRemark(rs.getString("Remark"));
        entity.setLastUpdate(rs.getDate("LastUpdate").toLocalDate());
        fillEntitySpecificFromResultSet(entity, rs);
    }



    public  T getById(int id) {
        T entity = getEntity();
        String selectSQL = "SELECT * FROM " + getTableName()+ " WHERE id=?" ;

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )        {
            ps.setInt(1,id);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    fillEntity(rs, entity);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public  T getByName(String name) {
        T entity = getEntity();
        String selectSQL = "SELECT * FROM " + getTableName()+ " WHERE " + getNameColumn() + "=?" ;

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL)  )        {
            ps.setString(1,name);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    fillEntity(rs, entity);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public  boolean save (T entity){
        boolean success = false;

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(getInsertScript()))
        {
            ps.setBoolean(1, true);
            fillPreparedStatementFromEntity(entity, ps);
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }


    public  boolean update (T entity){
        boolean success = false;

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(getUpdateScript() + entity.getId()))
        {
            ps.setBoolean(1,entity.isActive());
            fillPreparedStatementFromEntity(entity,ps);

            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  success;
    }


    public  boolean  deleteById (int id){
        boolean success = false;
        String deleteSQL = "DELETE FROM " + getTableName() + " WHERE id=?" ;
        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(deleteSQL))
        {
            ps.setInt(1,id);
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }


    public  List<String> getRussianColumnNames(){
        List <String> result = new ArrayList<>();
        String selectSQL = "SELECT RUSSIAN FROM u_column_names ";

        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(selectSQL);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
                String columnName = rs.getString("Russian");
                result.add(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

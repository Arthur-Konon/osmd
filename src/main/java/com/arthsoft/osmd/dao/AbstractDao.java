package com.arthsoft.osmd.dao;

import com.arthsoft.osmd.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by arthk on 21.09.2017.
 */
public abstract class AbstractDao {

    public static boolean  deleteById (Entity md){
        boolean success = false;
        String deleteSQL = "DELETE FROM ? WHERE id=?";
        try (Connection dbConnection = DbUtils.getDBConnection();
             PreparedStatement ps = dbConnection.prepareStatement(deleteSQL))
        {
            ps.setString(1,md.TABLE_NAME);
            ps.setInt(2, md.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}

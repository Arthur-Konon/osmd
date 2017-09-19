package com.arthsoft.osmd.dao;

import java.sql.*;

/**
 * Created by arthk on 11.09.2017.
 */
public class DbUtils {


        private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/arth_osmd?characterEncoding=UTF-8";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "root";


            public static java.sql.Connection getDBConnection() throws SQLException {
            try { Class.forName(DB_DRIVER);}
            catch (ClassNotFoundException e) {e.printStackTrace();}
            return DriverManager.getConnection( DB_CONNECTION, DB_USER, DB_PASSWORD);
        }


  /*  public static ResultSet  sqlQuery (String query) throws Exception{
        Connection dbConnection = DbUtils.getDBConnection();
        PreparedStatement ps = dbConnection.prepareStatement(query);
        return ps.executeQuery();
    }*/
}

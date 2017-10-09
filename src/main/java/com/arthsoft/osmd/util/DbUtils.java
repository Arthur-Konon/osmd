package com.arthsoft.osmd.util;

import com.arthsoft.osmd.Main;
import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by arthk on 11.09.2017.
 */
public class DbUtils {


       private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
       private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/arth_osmd?characterEncoding=UTF-8";
       private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "root";

    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

        public static void runFlyway() throws IOException {
            Properties dbProps = new Properties();
            try (InputStream stream = Main.class.getClassLoader()
                    .getResourceAsStream("db.properties")){
                dbProps.load(stream);
            }

            Flyway flyway = new Flyway();
            flyway.setDataSource(dbProps.getProperty(URL),
                    dbProps.getProperty(USER),
                    dbProps.getProperty(PASSWORD));
            flyway.migrate();
        }


            public static java.sql.Connection getDBConnection() throws SQLException {
            try { Class.forName(DB_DRIVER);}
            catch (ClassNotFoundException e) {e.printStackTrace();}

            return DriverManager.getConnection( DB_CONNECTION, DB_USER, DB_PASSWORD);
        }

}

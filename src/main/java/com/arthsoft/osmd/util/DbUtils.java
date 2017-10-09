package com.arthsoft.osmd.util;

import com.arthsoft.osmd.Main;
import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by arthk on 11.09.2017.
 */
public class DbUtils {


    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static Properties dbProps;

    static {
        dbProps = new Properties();
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            dbProps.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void runFlyway() throws IOException {


        Flyway flyway = new Flyway();
        flyway.setDataSource(dbProps.getProperty(URL),
                dbProps.getProperty(USER),
                dbProps.getProperty(PASSWORD));
        flyway.migrate();
    }


    public static java.sql.Connection getDBConnection() throws SQLException {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(dbProps.getProperty(URL), dbProps.getProperty(USER), dbProps.getProperty(PASSWORD));
    }

}

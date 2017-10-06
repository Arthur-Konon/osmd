package com.arthsoft.osmd;

import com.arthsoft.osmd.dao.*;
import com.arthsoft.osmd.entity.BenefitsType;
import com.arthsoft.osmd.entity.CompanyInfo;
import com.arthsoft.osmd.entity.User;
import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by arthk on 12.09.2017.
 */
public class Main {

    private static final String URL = "url";
    private static final String USER = "user";
    private static final String PWD = "password";

    public static void main(String[] args) throws IOException {

        Properties dbProps = new Properties();
            try (InputStream stream = Main.class.getClassLoader()
                    .getResourceAsStream("db.properties")){
                dbProps.load(stream);
            }

        Flyway flyway = new Flyway();
        flyway.setDataSource(dbProps.getProperty(URL),
                dbProps.getProperty(USER),
                dbProps.getProperty(PWD));
        flyway.migrate();


        new ApartmentDao().printEntityList(new ApartmentDao().getAll());
    }


}


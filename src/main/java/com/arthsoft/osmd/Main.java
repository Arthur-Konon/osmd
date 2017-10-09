package com.arthsoft.osmd;

import com.arthsoft.osmd.dao.*;
import com.arthsoft.osmd.entity.BenefitsType;
import com.arthsoft.osmd.entity.CompanyInfo;
import com.arthsoft.osmd.entity.User;
import com.arthsoft.osmd.util.DbUtils;
import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by arthk on 12.09.2017.
 */
public class Main {



    public static void main(String[] args) throws IOException {

       // DbUtils.runFlyway();


       new PersonDao().save(new PersonDao().getById(2));
    }


}


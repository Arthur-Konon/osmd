package com.arthsoft.osmd;

import com.arthsoft.osmd.dao.PersonDao;

import java.io.IOException;


/**
 * Created by arthk on 12.09.2017.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        // DbUtils.runFlyway();


        new PersonDao().save(new PersonDao().getById(2));
    }


}


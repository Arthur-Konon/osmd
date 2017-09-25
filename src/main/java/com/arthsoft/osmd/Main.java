package com.arthsoft.osmd;

import com.arthsoft.osmd.dao.*;
import com.arthsoft.osmd.entity.*;




/**
 * Created by arthk on 12.09.2017.
 */
public class Main {
    public static void main(String[] args) {

        new UserDao().update((User)new UserDao().getById(9));
        new UserDao().save((User)new UserDao().getById(9));
        new UserDao().deleteById(13);
        new UserDao().printEntity(new UserDao().getAll());

       // new HouseDao().deleteById(21);
       // new HouseDao().save((House)new HouseDao().getById(15));
      // new HouseDao().update((House)new HouseDao().getById(14));
      // new HouseDao().printEntity(new HouseDao().getAll());




    }
}


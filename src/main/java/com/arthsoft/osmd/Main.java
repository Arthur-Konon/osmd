package com.arthsoft.osmd;

import com.arthsoft.osmd.dao.ApartmentDao;


/**
 * Created by arthk on 12.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        //HouseDao.printHouses(HouseDao.getAll());
       //System.out.println(HouseDao.getById(7));
       // System.out.println(HouseDao.save(HouseDao.getById(4)) );
        //System.out.println(HouseDao.deleteById(16));
        //System.out.println(HouseDao.update(HouseDao.getById(6)));


       ApartmentDao.printApartments(ApartmentDao.getAll());
        //System.out.println(ApartmentDao.getById(1));
        //System.out.println(ApartmentDao.save(ApartmentDao.getById(1)));
        //System.out.println(ApartmentDao.deleteById(10));
        //System.out.println(ApartmentDao.update(ApartmentDao.getById(1)));

        //UserDao.printUsers(UserDao.getAll());
        //System.out.println(UserDao.getById(1));
        //System.out.println(UserDao.save(UserDao.getById(1)));
        //System.out.println(UserDao.deleteById(4));
        //System.out.println(UserDao.update(UserDao.getById(1)));
    }
}

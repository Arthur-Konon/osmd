package com.arthsoft.osmd;

import com.arthsoft.osmd.dao.*;
import com.arthsoft.osmd.entity.BenefitsType;
import com.sun.org.apache.xpath.internal.SourceTree;


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


       //ApartmentDao.printApartments(ApartmentDao.getAll());
        //System.out.println(ApartmentDao.getById(1));
        //System.out.println(ApartmentDao.save(ApartmentDao.getById(1)));
        //System.out.println(ApartmentDao.deleteById(10));
        //System.out.println(ApartmentDao.update(ApartmentDao.getById(1)));

        UserDao.printUsers(UserDao.getAll());
        //System.out.println(UserDao.getById(1));
        //System.out.println(UserDao.save(UserDao.getById(1)));
        //System.out.println(UserDao.deleteById(4));
        //System.out.println(UserDao.update(UserDao.getById(1)));

        //BenefitDao.printBenefits(BenefitDao.getAll());
        //System.out.println(BenefitDao.deleteById(1));
        //System.out.println(BenefitDao.getById(3));
        //System.out.println(BenefitDao.save(BenefitDao.getById(3)));
        //System.out.println(BenefitDao.deleteById(5));

        //ServiceDao.printServices(ServiceDao.getAll());
        //System.out.println(ServiceDao.getById(2));
        //System.out.println(ServiceDao.save(ServiceDao.getById(2)));
        //System.out.println(ServiceDao.deleteById(3));
        //System.out.println(ServiceDao.update(ServiceDao.getById(2)));

        //BenefitsTypeDao.printBenefitsTypes(BenefitsTypeDao.getAll());
        //System.out.println(BenefitsTypeDao.getById(1));
        //System.out.println(BenefitsTypeDao.save(BenefitsTypeDao.getById(1)));
        //System.out.println(BenefitsTypeDao.update(BenefitsTypeDao.getById(1)));
        //System.out.println(BenefitsTypeDao.deleteById(3));



    }
}

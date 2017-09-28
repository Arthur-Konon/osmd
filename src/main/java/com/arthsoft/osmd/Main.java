package com.arthsoft.osmd;

import com.arthsoft.osmd.dao.*;
import com.arthsoft.osmd.entity.BenefitsType;
import com.arthsoft.osmd.entity.CompanyInfo;
import com.arthsoft.osmd.entity.Position;


/**
 * Created by arthk on 12.09.2017.
 */
public class Main {
    public static void main(String[] args) {

        //new BenefitDao().update(new BenefitDao().getById(7));
        //new BenefitDao().deleteById(4);
        //new BenefitDao().save(new BenefitDao().getById(3));
        //new BenefitDao().printEntityList(new BenefitDao().getAll());

     new  HouseDao().update((new HouseDao().getById(3)));
      new HouseDao().printEntityList(new HouseDao().getAll());


    }
}


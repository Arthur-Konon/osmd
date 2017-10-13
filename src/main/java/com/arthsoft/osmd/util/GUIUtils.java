package com.arthsoft.osmd.util;

import com.arthsoft.osmd.dao.PersonDao;
import com.arthsoft.osmd.entity.Apartment;
import com.arthsoft.osmd.entity.Person;

public class GUIUtils {

    public static String getFirstNameWithInitials(Integer id) {
        Person supervisor = new PersonDao().getById(id);
        //TODO use stringBuilder instead of strings concatenation
        return supervisor.getFirstName() + " " +
                supervisor.getLastName().substring(0, 1) + ". " +
                supervisor.getPatronymic().substring(0, 1) + ".";

    }

}

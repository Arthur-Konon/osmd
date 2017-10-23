package com.arthsoft.osmd.util;

import com.arthsoft.osmd.dao.PersonDao;
import com.arthsoft.osmd.entity.Person;

public class GUIUtils {

    public static String getFirstNameWithInitials(Integer id) {
        Person person = new PersonDao().getById(id);
        StringBuilder firstNameWithInitials = new StringBuilder(person.getFirstName());
        firstNameWithInitials.append(" ").append(person.getLastName().substring(0, 1)).
                append(" ").append(person.getPatronymic().substring(0, 1)).append(".");

        return firstNameWithInitials.toString();

    }

}

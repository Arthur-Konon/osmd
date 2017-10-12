package com.arthsoft.osmd.gui.internal_frames.lists;

import com.arthsoft.osmd.dao.PersonDao;
import com.arthsoft.osmd.entity.Person;
import com.arthsoft.osmd.gui.MainWindow;
import com.arthsoft.osmd.gui.internal_frames.entities.PersonWindow;

import javax.swing.table.DefaultTableModel;

/**
 * Created by arthk on 10.10.2017.
 */
public class PeopleListWindow extends EntitiesListWindow {

    public PeopleListWindow(String title, String iconPath) {
        super(title, iconPath);
    }


    @Override
    DefaultTableModel createModel() {
        String[] columnNames = new PersonDao().getRussianColumnNames().toArray(new String[0]);


        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames) {


            @Override
            public Class getColumnClass(int column) {

                return getValueAt(1, column).getClass();
            }
        };


        java.util.List <Person> list = new PersonDao().getAll();
        for (Person cell : list) {
            Object[] o = new Object[16];
            o[0] = cell.getId();
            o[1] = cell.isActive();
            o[2] = cell.getFirstName();
            o[3] = cell.getLastName();
            o[4] = cell.getPatronymic();
            o[5] = cell.getResidApartId();
            o[6] = cell.getRegApartId();
            o[7] = cell.getBirthDate();
            o[8] = cell.getPhone();
            o[9] = cell.getTaxNum();
            o[10] = cell.getPassportSeries();
            o[11] = cell.getPassportNum();
            o[12] = cell.getIssuedBy();
            o[13] = cell.getIssuedDate();
            o[14] = cell.getRemark();
            o[15] = cell.getLastUpdate();
            model.addRow(o);
        }
        return model;
    }

    @Override
    void createEntityWindow(String iconPath, int id) {
        MainWindow.getInternalWindowsPane().add(new PersonWindow("Гражданин редактирование", iconPath));
    }
}
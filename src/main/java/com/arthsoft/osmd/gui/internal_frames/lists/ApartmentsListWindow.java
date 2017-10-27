package com.arthsoft.osmd.gui.internal_frames.lists;

import com.arthsoft.osmd.dao.ApartmentDao;
import com.arthsoft.osmd.entity.Apartment;
import com.arthsoft.osmd.gui.MainWindow;
import com.arthsoft.osmd.gui.internal_frames.entities.EntityWindow;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by arthk on 11.10.2017.
 */
public class ApartmentsListWindow extends EntitiesListWindow {

    public ApartmentsListWindow(String title, String iconPath) {
        super(title, iconPath);
    }


    void createEntityWindow(String iconPath, int id) {
        Apartment apartment = new ApartmentDao().getById(id);

        Field[] fields = getEntityFields();
        Object[] row = translateEntityToRow(apartment, fields);

        MainWindow.getInternalWindowsPane().add(new EntityWindow("Квартира редактирование", iconPath, columnNames, row));

    }

    TableModel createModel() {
        Field[] fields = getEntityFields();

        columnNames = fetchNames(fields);

        List <Apartment> apartments = new ApartmentDao().getAll();

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class getColumnClass(int column) {
                if (getValueAt(1, column) != null)
                    return getValueAt(1, column).getClass();
                else return String.class;
            }
        };

        for (Apartment apartment : apartments) {
            Object[] row = translateEntityToTableRow(apartment, fields);
            tableModel.addRow(row);
        }

        return tableModel;
    }

    private Field[] getEntityFields() {
        Class aClass = Apartment.class;
        return fetchFields(aClass);
    }

}

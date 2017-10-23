package com.arthsoft.osmd.gui.internal_frames.lists;

import com.arthsoft.osmd.dao.EmployeeDao;
import com.arthsoft.osmd.entity.Employee;
import com.arthsoft.osmd.gui.MainWindow;
import com.arthsoft.osmd.gui.internal_frames.entities.EntityWindow;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by arthk on 21.10.2017.
 */
public class EmployeesListWindow extends EntitiesListWindow {
    public EmployeesListWindow(String title, String iconPath) {
        super(title, iconPath);
    }

    TableModel createModel() {
        Field[] fields = getFields();
        columnNames = fetchNames(fields);

        List <Employee> employees = new EmployeeDao().getAll();

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class getColumnClass(int column) {
                if (getValueAt(1, column) != null)
                    return getValueAt(1, column).getClass();
                else return String.class;
            }
        };

        for (Employee employee : employees) {
            Object[] row = translateEntityToTableRow(employee, fields);
            tableModel.addRow(row);
        }

        return tableModel;
    }

    @Override
    void createEntityWindow(String iconPath, int id) {
        Employee employee = new EmployeeDao().getById(id);
        Field[] fields = getFields();
        Object[] row = translateEntityToTableRow(employee, fields);
        MainWindow.getInternalWindowsPane().add(new EntityWindow("Сотрудник редактирование", iconPath, columnNames, row));
    }

    private Field[] getFields() {
        Class eClass = Employee.class;
        return fetchFields(eClass);
    }
}

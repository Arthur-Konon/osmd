package com.arthsoft.osmd.gui.internal_frames.lists;

import com.arthsoft.osmd.dao.ApartmentDao;
import com.arthsoft.osmd.dao.HouseDao;
import com.arthsoft.osmd.dao.PersonDao;
import com.arthsoft.osmd.entity.Apartment;
import com.arthsoft.osmd.gui.MainWindow;
import com.arthsoft.osmd.gui.internal_frames.entities.ApartmentWindow;

import javax.swing.table.DefaultTableModel;

/**
 * Created by arthk on 11.10.2017.
 */
public class ApartmentsListWindow extends EntitiesListWindow {

    public ApartmentsListWindow(String title, String iconPath) {
        super(title, iconPath);
    }

    @Override
    DefaultTableModel createModel() {
        String[] columnNames = new ApartmentDao().getRussianColumnNames().toArray(new String[0]);
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames)

        {
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(1, column).getClass();
            }
        };

        java.util.List <Apartment> list = new ApartmentDao().getAll();
        for (Apartment cell : list) {
            Object[] o = new Object[15];
            o[0] = cell.getId();
            o[1] = cell.isActive();
            //o[2] = cell.getGuiAddress();
            o[2] = new HouseDao().getById(cell.getId()).getAddress();

            o[3] = cell.getApartNum();
            o[4] = getFirstNameWithInitials(cell);
            //o[4] = cell.getGuiSupervisor();
            o[5] = cell.getTotalArea();
            o[5] = cell.getTotalArea();
            o[6] = cell.getHeatedArea();
            o[7] = cell.getUsefulArea();
            o[8] = cell.isPrivacy();
            o[9] = cell.getCellPhone();
            o[10] = cell.getRegTenantQty();
            o[11] = cell.getActTenantsQty();
            o[12] = cell.isResidentialFund();
            o[13] = cell.getRemark();
            o[14] = cell.getLastUpdate();
            model.addRow(o);
        }
        return model;
    }


    private String getFirstNameWithInitials(Apartment ap) {
        return new PersonDao().getById(ap.getSupervisorId()).getFirstName() + " " +
                new PersonDao().getById(ap.getSupervisorId()).getLastName().substring(0, 1) + ". " +
                new PersonDao().getById(ap.getSupervisorId()).getPatronymic().substring(0, 1) + ".";

    }

    void createEntityWindow(String iconPath) {
        MainWindow.getInternalWindowsPane().add(new ApartmentWindow("Квартира редактирование", iconPath));
    }
}

package com.arthsoft.osmd.gui.demo;

import com.arthsoft.osmd.dao.PersonDao;
import com.arthsoft.osmd.entity.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.beans.PropertyVetoException;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by arthk on 06.10.2017.
 */
public class Old_ent_list_window extends JInternalFrame {

    public Old_ent_list_window(String iconPath) {
        super("",
                true,
                true,
                true,
                true);

        // What is this?
        invokeLater(new Runnable() {
            public void run() {
                try {
                    setMaximum(true);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
            }
        });
        setBounds(100, 100, 800, 600);
        setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(iconPath))));
        createEntityTable();

    }


    private void createEntityTable() {


        String[] columnNames = new PersonDao().getRussianColumnNames().toArray(new String[0]);


        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames) {

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return getValueAt(1, column).getClass();
                    case 5:
                        return Integer.class;
                    case 6:
                        return Integer.class;
                    case 7:
                        return getValueAt(1, column).getClass();
                    case 11:
                        return Integer.class;
                    case 13:
                        return getValueAt(1, column).getClass();
                    case 15:
                        return getValueAt(1, column).getClass();

                    default:
                        return String.class;
                }
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
        JTable table = new JTable(model);

        table.setPreferredScrollableViewportSize(new Dimension(getWidth(), 70));
        table.setFillsViewportHeight(true);


        TableRowSorter <TableModel> sorter = new TableRowSorter <>(table.getModel());
        table.setRowSorter(sorter);


        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

}


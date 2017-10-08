package com.arthsoft.osmd.gui;

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
public class EntitiesListWindow extends JInternalFrame {

    public EntitiesListWindow() {
        super("" ,
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

        createEntilyTable();

    }

private JTable createEntilyTable() {

    //super(new GridLayout(1,0));

    String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

    Object[][] data = {
            {"Kathy", "Smith",
                    "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                    "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                    "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                    "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                    "Pool", new Integer(10), new Boolean(false)}
    };

    final JTable table = new JTable(data, columnNames);
    table.setPreferredScrollableViewportSize(new Dimension(getWidth(), 70));
    table.setFillsViewportHeight(true);

    TableModel model = new DefaultTableModel(data, columnNames) {
        public Class <?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    TableRowSorter <TableModel> sorter = new TableRowSorter <TableModel>(model);
    table.setRowSorter(sorter);


    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);

    //Add the scroll pane to this panel.
    add(scrollPane);
    return table;
    }

}


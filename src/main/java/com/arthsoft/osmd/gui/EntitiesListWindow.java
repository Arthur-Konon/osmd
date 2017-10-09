package com.arthsoft.osmd.gui;

import com.arthsoft.osmd.dao.PersonDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.Vector;

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

        createEntityTable();

    }

    private  DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns from Database
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }


        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

                return new DefaultTableModel(data, columnNames);

    }

private void createEntityTable() {

    JTable table = null;

    try {
        table = new JTable(buildTableModel(new PersonDao().getAllAsRusultSet()));
    } catch (SQLException e) {
        e.printStackTrace();
    }


    assert table != null;
    table.setPreferredScrollableViewportSize(new Dimension(getWidth(), 70));
    table.setFillsViewportHeight(true);

    TableRowSorter <TableModel> sorter = null;
    try {
        sorter = new TableRowSorter<>(buildTableModel(new PersonDao().getAllAsRusultSet()));
    } catch (SQLException e) {
        e.printStackTrace();
    }
    table.setRowSorter(sorter);
    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);

    //Add the scroll pane to this panel.
    add(scrollPane);
     }

}


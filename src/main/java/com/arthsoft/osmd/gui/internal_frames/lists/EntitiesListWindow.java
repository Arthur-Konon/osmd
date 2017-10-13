package com.arthsoft.osmd.gui.internal_frames.lists;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by arthk on 10.10.2017.
 */

abstract class EntitiesListWindow extends JInternalFrame {

    private String iconPath;

    EntitiesListWindow(String title, String iconPath) {

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
        this.iconPath = iconPath;
        setTitle(title);
        setBounds(100, 100, 800, 600);
        setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(iconPath))));
        createTable();
        setVisible(true);

        try {
            setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }


    }


    private void createTable() {

        JTable table = new JTable(createModel());

        table.setPreferredScrollableViewportSize(new Dimension(getWidth(), 70));
        table.setFillsViewportHeight(true);

        TableRowSorter <TableModel> sorter = new TableRowSorter <>(table.getModel());
        table.setRowSorter(sorter);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);

        // invoke an entity window by double click

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                // JTable table =(JTable) me.getSource();
                //Point p = me.getPoint();
                //int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {

                    int column = 0;
                    int row = table.getSelectedRow();
                    int id = (int) table.getModel().getValueAt(row, column); //todo try to change sort order before double click
                    createEntityWindow(iconPath, id);
                }
            }
        });

    }

    abstract TableModel createModel();

    abstract void createEntityWindow(String iconPath, int id);


}

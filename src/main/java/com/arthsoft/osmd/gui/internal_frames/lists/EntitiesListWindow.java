package com.arthsoft.osmd.gui.internal_frames.lists;

import com.arthsoft.osmd.annotations.Calculation;
import com.arthsoft.osmd.annotations.Name;
import com.arthsoft.osmd.annotations.Names;
import com.arthsoft.osmd.entity.Entity;
import com.arthsoft.osmd.util.AppUtils;
import com.arthsoft.osmd.util.GUIUtils;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by arthk on 10.10.2017.
 */

abstract class EntitiesListWindow extends JInternalFrame {

    String[] columnNames;
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
                    // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    setMaximum(true);
                } catch (/*ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException |*/ PropertyVetoException e) {
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

    abstract TableModel createModel();

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
                    int rowInOrder = table.getSelectedRow();
                    int trueRow = table.convertRowIndexToModel(rowInOrder);
                    int id = (int) table.getModel().getValueAt(trueRow, column);
                    createEntityWindow(iconPath, id);
                }
            }
        });
    }


    public Object[] translateEntityToTableRow(Entity entity, Field[] fields) {
        return Arrays.stream(fields)
                .map(field -> getFieldValue(entity, field))
                .toArray();
    }

    protected Object getFieldValue(Object object, Field field) {
        try {
            if (field.isAnnotationPresent(Calculation.class)) {
                return calculateFieldValue(object, field);
            }
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    protected Object calculateFieldValue(Object object, Field field) throws Exception {
        String methodName = field.getAnnotation(Calculation.class).methodName();
        Object arg = field.get(object);
        return GUIUtils.class
                .getMethod(methodName, arg.getClass())
                .invoke(null, arg);
    }

    protected Field[] fetchFields(Class <Entity> entityClass) {
        Field[] declaredFields = entityClass.getDeclaredFields();
        Field[] entityFields = Entity.class.getDeclaredFields();
        return Stream.concat(Stream.of(entityFields), Stream.of(declaredFields))
                .filter(this::isNamedField)
                .peek(field -> field.setAccessible(true))
                .toArray(Field[]::new);
    }

    protected boolean isNamedField(Field field) {
        return field.isAnnotationPresent(Names.class) || field.isAnnotationPresent(Name.class);
    }

    protected String[] fetchNames(Field[] fields) {
        java.util.List <String> names = new ArrayList <>();
        for (Field field : fields) {
            String name = fetchName(field);
            names.add(name);
        }
        return names.stream().toArray(String[]::new);
    }

    protected String fetchName(Field field) {
        return Arrays.stream(field.getAnnotationsByType(Name.class))
                .filter(name -> AppUtils.getLanguage() == name.language())
                .map(Name::name)
                .findFirst()
                .orElse(field.getName());
    }

    abstract void createEntityWindow(String iconPath, int id);


    public Object[] translateEntityToRow(Entity entity, Field[] fields) {
        return Arrays.stream(fields)
                .map(field -> getFieldValueAsItIs(entity, field))
                .toArray();
    }

    protected Object getFieldValueAsItIs(Object object, Field field) {
        try {
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

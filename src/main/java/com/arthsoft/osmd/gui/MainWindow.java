package com.arthsoft.osmd.gui;

import java.awt.*;

import javax.swing.*;

import static java.awt.Color.GRAY;
import static java.awt.Color.RED;


/**
 * Created by arthk on 06.10.2017.
 */
public class MainWindow extends JFrame{

    private static String entityListWindowName = "";

    public static void main(String[] args) {
        new MainWindow();
    }

    private JDesktopPane entityListWindowsPane;

    public MainWindow() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/House.png")));
        Toolkit.getDefaultToolkit();
        setTitle("OSMD");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);

            }

    //Create a new internal frame.
    private void createEntityListWindow() {
        EntitiesListWindow internalWindow = new EntitiesListWindow();
        internalWindow.setVisible(true);
        entityListWindowsPane.add(internalWindow);
        try {
            internalWindow.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
        internalWindow.setTitle(entityListWindowName);
    }

    private void initComponents() {

        entityListWindowsPane = new JDesktopPane(); //a specialized layered pane

        setContentPane(entityListWindowsPane);

        entityListWindowsPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        JMenu masterData_menu = new JMenu("\tMaster Data\t");
        JMenu documents_menu = new JMenu("\tDocuments\t");
        JMenu payments_menu = new JMenu("\tPayments\t");
        JMenu settings_menu = new JMenu("\tSettings\t");

        menuBar.add(masterData_menu);
        menuBar.add(documents_menu);
        menuBar.add(payments_menu);
        menuBar.add(settings_menu);

        JMenuItem people_menu_item = new JMenuItem("People");
        JMenuItem apartments_menu_item = new JMenuItem("Apartments");
        JMenuItem benefits_menu_item = new JMenuItem("Benefits");

        JMenuItem sales_menu_item = new JMenuItem("Sales");
        JMenuItem refunds_menu_item = new JMenuItem("Refunds");
        JMenuItem purchases_menu_item = new JMenuItem("Purchases");

        JMenuItem incPayments_menu_item = new JMenuItem("Incoming Payments");
        JMenuItem outPayments_menu_item = new JMenuItem("Outgoing Payments");


        masterData_menu.add(people_menu_item);
        masterData_menu.add(apartments_menu_item);
        masterData_menu.add(benefits_menu_item);

        documents_menu.add(sales_menu_item);
        documents_menu.add(refunds_menu_item);
        documents_menu.add(purchases_menu_item);

        payments_menu.add(incPayments_menu_item);
        payments_menu.add(outPayments_menu_item);

        people_menu_item.addActionListener(e -> {
            entityListWindowName = "People";
            createEntityListWindow();
        });

    }
}

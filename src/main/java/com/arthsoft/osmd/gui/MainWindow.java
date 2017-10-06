package com.arthsoft.osmd.gui;


import com.arthsoft.osmd.entity.User;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import static javax.swing.SwingUtilities.getWindowAncestor;

/**
 * Created by arthk on 06.10.2017.
 */
public class MainWindow extends JFrame{
   // private static final long serialVersionUID = 2785294706787223082L;
    //private int x = 0, y=0 , width = 800, height = 600;





    public MainWindow() {

        //getWindowAncestor(this);
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/House.png")));
        Toolkit.getDefaultToolkit();

        /*
        Dimension d = t.getScreenSize();
        x = (int) ((d.getWidth() - width) / 2);
        y = (int) ((d.getHeight() - height) / 2);
        setBounds(x, y, widht, height);
        */

        setTitle("OSMD");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.initComponents();

        setVisible(true);
    }

    private void initComponents() {

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu masterData_menu = new JMenu(" Master Data ");
        JMenu documents_menu = new JMenu(" Documents ");
        JMenu payments_menu = new JMenu(" Payments ");
        JMenu settings_menu = new JMenu(" Settings ");

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

        people_menu_item.addActionListener(e -> new EntitiesListWindow());

    }


   // public static void main(String[] args) {
   //     new MainWindow();
   // }

}

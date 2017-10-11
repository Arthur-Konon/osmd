package com.arthsoft.osmd.gui;

import com.arthsoft.osmd.gui.internal_frames.ApartmentsListWindow;
import com.arthsoft.osmd.gui.internal_frames.PeopleListWindow;

import javax.swing.*;
import java.awt.*;


/**
 * Created by arthk on 06.10.2017.
 */
public class MainWindow extends JFrame {


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


    private void initComponents() {

        entityListWindowsPane = new JDesktopPane(); //a specialized layered pane

        setContentPane(entityListWindowsPane);

        entityListWindowsPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        JMenu masterData_menu = new JMenu("\tСправочники\t");
        JMenu documents_menu = new JMenu("\tДокументы\t");
        JMenu payments_menu = new JMenu("\tПлатежи\t");
        JMenu settings_menu = new JMenu("\tНастройки\t");

        menuBar.add(masterData_menu);
        menuBar.add(documents_menu);
        menuBar.add(payments_menu);
        menuBar.add(settings_menu);

        JMenuItem people_menu_item = new JMenuItem("Люди");
        JMenuItem apartments_menu_item = new JMenuItem("Квартиры");
        JMenuItem benefits_menu_item = new JMenuItem("Льготы");

        JMenuItem sales_menu_item = new JMenuItem("Начисления");
        JMenuItem refunds_menu_item = new JMenuItem("Возвраты");
        JMenuItem purchases_menu_item = new JMenuItem("Покупки");

        JMenuItem incPayments_menu_item = new JMenuItem("Исходящие платежи");
        JMenuItem outPayments_menu_item = new JMenuItem("Входящие платежи");


        masterData_menu.add(people_menu_item);
        masterData_menu.add(apartments_menu_item);
        masterData_menu.add(benefits_menu_item);

        documents_menu.add(sales_menu_item);
        documents_menu.add(refunds_menu_item);
        documents_menu.add(purchases_menu_item);

        payments_menu.add(incPayments_menu_item);
        payments_menu.add(outPayments_menu_item);

        people_menu_item.addActionListener(e -> {
            entityListWindowsPane.add(new PeopleListWindow("Люди", "/img/grey-man-icon.png"));

        });
        apartments_menu_item.addActionListener(e -> {
            entityListWindowsPane.add(new ApartmentsListWindow("Квартиры", "/img/apartment_icon.png"));
        });

    }
}

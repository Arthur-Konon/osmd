package com.arthsoft.osmd.gui;

import com.arthsoft.osmd.gui.internal_frames.entities.EntityWindow;
import com.arthsoft.osmd.gui.internal_frames.lists.ApartmentsListWindow;
import com.arthsoft.osmd.gui.internal_frames.lists.PeopleListWindow;

import javax.swing.*;
import java.awt.*;


/**
 * Created by arthk on 06.10.2017.
 */
public class MainWindow extends JFrame {

    private static JDesktopPane internalWindowsPane;

    public MainWindow() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/House.png")));
        setTitle("OSMD");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    public static JDesktopPane getInternalWindowsPane() {
        return internalWindowsPane;
    }

    private void initComponents() {
        internalWindowsPane = new JDesktopPane(); //a specialized layered pane
        setContentPane(internalWindowsPane);
        internalWindowsPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(generateMasterData());
        menuBar.add(generateDocMenu());
        menuBar.add(generatePaymentMenu());
        menuBar.add(generateSettingsMenu());
        setJMenuBar(menuBar);
    }

    private JMenu generateSettingsMenu() {
        JMenu settings_menu = new JMenu("\tНастройки\t");
        return settings_menu;
    }

    private JMenu generatePaymentMenu() {
        JMenuItem incPayments_menu_item = new JMenuItem("Исходящие платежи");
        JMenuItem outPayments_menu_item = new JMenuItem("Входящие платежи");

        JMenu payments_menu = new JMenu("\tПлатежи\t");
        payments_menu.add(incPayments_menu_item);
        payments_menu.add(outPayments_menu_item);
        return payments_menu;
    }

    private JMenu generateDocMenu() {
        JMenuItem sales_menu_item = new JMenuItem("Начисления");
        JMenuItem refunds_menu_item = new JMenuItem("Возвраты");
        JMenuItem purchases_menu_item = new JMenuItem("Покупки");

        JMenu documents_menu = new JMenu("\tДокументы\t");
        documents_menu.add(sales_menu_item);
        documents_menu.add(refunds_menu_item);
        documents_menu.add(purchases_menu_item);
        return documents_menu;
    }

    private JMenu generateMasterData() {
        JMenuItem people_menu_item = new JMenuItem("Люди");
        JMenuItem apartments_menu_item = new JMenuItem("Квартиры");
        JMenuItem benefits_menu_item = new JMenuItem("Льготы");
        people_menu_item.addActionListener(e -> {
            internalWindowsPane.add(new PeopleListWindow("Люди", "/img/grey-man-icon.png"));

        });
        apartments_menu_item.addActionListener(e -> {
            internalWindowsPane.add(new ApartmentsListWindow("Квартиры", "/img/apartment_icon.png"));
        });
/*
        benefits_menu_item.addActionListener(e -> {
            internalWindowsPane.add(new EntityWindow("Редактировать квартиру", "/img/apartment_icon.png"));
        });
*/
        JMenu masterData_menu = new JMenu("\tСправочники\t");
        masterData_menu.add(people_menu_item);
        masterData_menu.add(apartments_menu_item);
        masterData_menu.add(benefits_menu_item);
        return masterData_menu;
    }
}

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
        JMenu settingsMenu = new JMenu("\tНастройки\t");
        return settingsMenu;
    }

    private JMenu generatePaymentMenu() {
        JMenuItem incPaymentsMenuItem = new JMenuItem("Исходящие платежи");
        JMenuItem outPaymentsMenuItem = new JMenuItem("Входящие платежи");

        JMenu paymentsMenu = new JMenu("\tПлатежи\t");
        paymentsMenu.add(incPaymentsMenuItem);
        paymentsMenu.add(outPaymentsMenuItem);
        return paymentsMenu;
    }

    private JMenu generateDocMenu() {
        JMenuItem salesMenuItem = new JMenuItem("Начисления");
        JMenuItem refundsMenuItem = new JMenuItem("Возвраты");
        JMenuItem purchasesMenuItem = new JMenuItem("Покупки");

        JMenu documentsMenu = new JMenu("\tДокументы\t");
        documentsMenu.add(salesMenuItem);
        documentsMenu.add(refundsMenuItem);
        documentsMenu.add(purchasesMenuItem);
        return documentsMenu;
    }

    private JMenu generateMasterData() {
        JMenuItem peopleMenuItem = new JMenuItem("Люди");
        JMenuItem apartmentsMenuItem = new JMenuItem("Квартиры");
        JMenuItem benefitsMenuItem = new JMenuItem("Льготы");
        peopleMenuItem.addActionListener(e -> {
            internalWindowsPane.add(new PeopleListWindow("Люди", "/img/grey-man-icon.png"));

        });
        apartmentsMenuItem.addActionListener(e -> {
            internalWindowsPane.add(new ApartmentsListWindow("Квартиры", "/img/apartment_icon.png"));
        });
/*
        benefitsMenuItem.addActionListener(e -> {
            internalWindowsPane.add(new EntityWindow("Редактировать квартиру", "/img/apartment_icon.png"));
        });
*/
        JMenu masterDataMenu = new JMenu("\tСправочники\t");
        masterDataMenu.add(peopleMenuItem);
        masterDataMenu.add(apartmentsMenuItem);
        masterDataMenu.add(benefitsMenuItem);
        return masterDataMenu;
    }
}

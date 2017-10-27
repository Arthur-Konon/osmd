package com.arthsoft.osmd.gui.internal_frames.entities;

import com.arthsoft.osmd.annotations.Calculation;
import com.arthsoft.osmd.entity.Apartment;
import com.arthsoft.osmd.entity.Entity;
import com.arthsoft.osmd.util.GUIUtils;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.util.Arrays;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by arthk on 11.10.2017.
 */
public class EntityWindow extends JInternalFrame {


    private static JComponent labelsAndFields;

    public EntityWindow(String title, String iconPath, String[] columnNames, Object[] row) {

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
        setTitle(title);
        setBounds(100, 100, 800, 600);
        setFrameIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(iconPath))));

        setVisible(true);

        try {
            setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

                 // top


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        topPanel.setBackground(Color.RED);
        //JButton sButton = new JButton("Сохранить");
        //JButton dButton = new JButton("Delete");

        // topPanel.add(sButton);
        // topPanel.add(dButton);
        add(topPanel, BorderLayout.NORTH);

               // centre


        JComponent[] components = new JComponent[columnNames.length];
        for (int i = 0; i < components.length; i++) {
            JTextField textField = new JTextField(30);
            //textField.setText("Text");
            if (row[i] != null)
                textField.setText(row[i].toString());
            components[i] = textField;

        }


        labelsAndFields = GUIUtils.getTwoColumnLayout(columnNames, components);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        contentPanel.add(labelsAndFields);
        add(contentPanel);


                     //footer with buttons

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton saveButton = new JButton("Сохранить");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submit();

            }
        });
        //saveButton.setActionCommand("OK");
        buttonPane.add(saveButton);
        //getRootPane().setDefaultButton(saveButton);


        JButton cancelButton = new JButton("Отменить");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //cancelButton.setActionCommand("Отменить");
        buttonPane.add(cancelButton);

    }

    private static void submit() {

            Component[] components = labelsAndFields.getComponents();
            Apartment apartment = new Apartment();
            for (Component comp : components) {
                // Cast comp to JComboBox / JTextField to get the values
                if (comp instanceof JTextField) {
                    JTextField textField = (JTextField) comp;
                    System.out.println(textField.getText());

                }

            }

    }

}

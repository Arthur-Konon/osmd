package com.arthsoft.osmd.gui.internal_frames.entities;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by arthk on 11.10.2017.
 */
public class EntityWindow extends JInternalFrame {

    public EntityWindow(String title, String iconPath) {

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


    }

}

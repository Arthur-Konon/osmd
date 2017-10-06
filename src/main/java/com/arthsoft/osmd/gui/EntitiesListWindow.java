package com.arthsoft.osmd.gui;

import com.arthsoft.osmd.entity.Entity;

import javax.swing.*;
import javax.swing.plaf.InternalFrameUI;
import java.awt.*;

/**
 * Created by arthk on 06.10.2017.
 */
public class EntitiesListWindow extends JInternalFrame {



/*
    public static void main(String[] args) {
        new EntitiesListWindow();
    }
    */


    public EntitiesListWindow(){

        super   ("\"People\"" ,
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable);

        /*
        int x , y , width = 800, height = 600;
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();

        x = (int) ((d.getWidth() - width) / 2);
        y = (int) ((d.getHeight() - height) / 2);
        setBounds(x, y, width, height);
        setResizable(false);

        setTitle("People");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.initComponents();
*/
        setVisible(true);

    }

    private void initComponents() {

    }



}

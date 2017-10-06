package com.arthsoft.osmd.gui;

import com.arthsoft.osmd.dao.UserDao;
import com.arthsoft.osmd.entity.User;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by arthk on 03.10.2017.
 */
public class LogIn extends JDialog {




    private  boolean authenticate(String username, String password) {
        String truePassword = new UserDao().getByName(username).getPassword();
        return password.equals(truePassword);
    }


    public static void main(String[] args) {
        try {
            LogIn dialog = new LogIn();
            dialog.setLocationRelativeTo(null);// align to centre
            dialog.setVisible(true); // is visible


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private LogIn() {
        super(null, ModalityType.TOOLKIT_MODAL); //put icon on windows toolbars
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // shut down app by closing window

        JPanel contentPanel = new JPanel();
       // setIconImage(Toolkit.getDefaultToolkit().getImage("resources/img/rsz_password_icon.png"));
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/rsz_password_icon.png")));


        setTitle("Login");
        setBounds(100, 100, 450, 256);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JTextField userNameField = new JTextField();
        userNameField.setColumns(10);

        JLabel userNameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        JLabel labelLoginToOSMD = new JLabel("Login to OSMD");
        labelLoginToOSMD.setForeground(SystemColor.textHighlight);
        labelLoginToOSMD.setFont(new Font("Georgia", Font.BOLD, 20));


        GroupLayout credentialFields = new GroupLayout(contentPanel);
        JPasswordField passwordField = new JPasswordField();


        credentialFields.setHorizontalGroup(
                credentialFields.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(credentialFields.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(credentialFields.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(userNameLabel)
                                        .addComponent(passwordLabel))
                                .addGap(18)
                                .addGroup(credentialFields.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField)
                                        .addComponent(userNameField, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                                .addContainerGap(38, Short.MAX_VALUE))
                        .addGroup(credentialFields.createSequentialGroup()
                                .addContainerGap(71, Short.MAX_VALUE)
                                .addComponent(labelLoginToOSMD)
                                .addGap(130))
        );

        credentialFields.setVerticalGroup(
                credentialFields.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(credentialFields.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelLoginToOSMD)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(credentialFields.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userNameLabel))
                                .addGap(18)
                                .addGroup(credentialFields.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(24))
        );

        contentPanel.setLayout(credentialFields);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);


                // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setActionCommand("OK");
        buttonPanel.add(loginButton);
        getRootPane().setDefaultButton(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (authenticate(userNameField.getText().trim(),new String (passwordField.getPassword()))) {
                    /*
                    JOptionPane.showMessageDialog(LogIn.this,
                            "Hi " + userNameField.getText().trim() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    */
                    dispose();
                    new MainWindow();
                } else {
                    JOptionPane.showMessageDialog(LogIn.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    userNameField.setText("");
                    passwordField.setText("");
                }
            }
        });


                // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(e -> dispose());
    }

}

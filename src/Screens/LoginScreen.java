package Screens;

import Utils.UserType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends AbstractScreen {
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;

    public LoginScreen(String title) {
        super("Login");

        // Initialize components
        username = new JTextField(20);
        password = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get username and password entered
                String enteredUsername = username.getText();
                String enteredPassword = new String(password.getPassword());

                // Print the username and password entered
                System.out.println("Username: " + enteredUsername);
                System.out.println("Password: " + enteredPassword);
                changeScreen(UserType.EMPLOYEE);
            }
        });

        // Set layout for the screen
        setLayout(new FlowLayout());

        // Add components to the screen
        add(new JLabel("Username:"));
        add(username);
        add(new JLabel("Password:"));
        add(password);
        add(loginButton);

        // Set screen visibility
        setVisible(true);
    }

    @Override
    public void changeScreen(UserType type) {
        dispose();
        switch(type){
            case EMPLOYEE -> new EmployeeScreen("Employee");
            case MANAGER -> new ManagerScreen("Manager");
            case CUSTOMER -> new CustomerScreen("Customer");
        }
    }
}

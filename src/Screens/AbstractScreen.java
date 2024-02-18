package Screens;

import Utils.UserType;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractScreen extends JFrame {
    protected JPanel containerPanel;
    protected CardLayout cardLayout;

    public AbstractScreen(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    public abstract void changeScreen(UserType type);
}

package GUI;

import GUI.PANELS.welcomePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mainFrame extends JFrame{

    public mainFrame(){
        super("Backgammon");
        GUI.menuBar theMenuBar = new menuBar();
        this.setJMenuBar(theMenuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setResizable(false);

        JPanel theWelcomePanel = new welcomePanel();

        this.add(theWelcomePanel);

        //this.pack();
        this.setVisible(true);

    }


}

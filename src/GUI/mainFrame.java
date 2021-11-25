package GUI;

import GAME.Backgammon;
import GUI.PANELS.welcomePanel;
import GUI.PANELS.boardPanel;

import javax.swing.*;
import java.awt.*;


public class mainFrame extends JFrame{

    public mainFrame(){
        super("Backgammon");

        // menuBar added onto the mainFrame
        GUI.menuBar theMenuBar = new menuBar();
        this.setJMenuBar(theMenuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setResizable(false);
        this.setVisible(true);

    }

    public static void welcomeScreen(){
        welcomePanel theWelcomePanel = new welcomePanel();
        Backgammon.theMainFrame.getContentPane().add(theWelcomePanel);
        theWelcomePanel.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);
    }

    public static void createEmptyBoardScreen(){
        boardPanel emptyBoardPanel = new boardPanel();
        Backgammon.theMainFrame.getContentPane().add(emptyBoardPanel);
        emptyBoardPanel.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);
    }

    public static void clearTheMainFramePanels(){
        Backgammon.theMainFrame.getContentPane().removeAll();
        Backgammon.theMainFrame.repaint();
    }

    public static void showDice() {
        dicePanel die = new dicePanel();
        Backgammon.theMainFrame.getContentPane().add(die);
        die.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);


    }

}

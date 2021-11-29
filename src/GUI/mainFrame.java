package GUI;

import GAME.Backgammon;
import GAME.Column;
import GAME.Game;
import GUI.PANELS.dicePanel;
import GUI.PANELS.moveButton;
import GUI.PANELS.welcomePanel;
import GUI.PANELS.boardPanel;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame{
    private static boardPanel theBoardPanel;
    private static dicePanel theDicePanel;

    public mainFrame(){
        super("Backgammon");

        // menuBar added onto the mainFrame
        GUI.menuBar theMenuBar = new menuBar();
        this.setJMenuBar(theMenuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800   );
        this.setResizable(false);
        this.setVisible(true);

    }

    public boardPanel getTheBoardPanel(){
        return theBoardPanel;
    }

    public dicePanel getTheDicePanel(){
        return theDicePanel;
    }

    public static void welcomeScreen(){
        welcomePanel theWelcomePanel = new welcomePanel();
        Backgammon.theMainFrame.getContentPane().add(theWelcomePanel);
        theWelcomePanel.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);
    }

    public static void createEmptyBoardScreen(){
        theBoardPanel = new boardPanel();

        theBoardPanel.setLayout(null);
        theBoardPanel.addMoveButtons();

        Backgammon.theMainFrame.getContentPane().add(theBoardPanel);

        theBoardPanel.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);
    }

    public static void clearTheMainFramePanels(){
        Backgammon.theMainFrame.getContentPane().removeAll();
        Backgammon.theMainFrame.repaint();
    }

    public static void showDice() {
        theDicePanel = new dicePanel();
        Backgammon.theMainFrame.getContentPane().add(theDicePanel);
        theDicePanel.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);


    }

    public static void showTurnButtons(){
        if (Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN){
            for (int i = 1; i <= 24; i++){
                if (Backgammon.theBoard.getTheColumns()[i].getPieceCount() > 0 // If Piece Count > 0
                        && Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.WHITE){ // Column Color is white
                    Backgammon.theBoard.getTheButtons()[i].setVisible(true); // Make the Button Visible
                }
                else{
                    Backgammon.theBoard.getTheButtons()[i].setVisible(false); // Make the Button Invisible
                }
            }
        }

        if (Backgammon.theGame.getCurrentTurn() == Game.BLACK_TURN){
            for (int i = 1; i <= 24; i++){
                if (Backgammon.theBoard.getTheColumns()[i].getPieceCount() > 0 // If Piece Count > 0
                        && Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.BLACK){ // Column Color is white
                    Backgammon.theBoard.getTheButtons()[i].setVisible(true); // Make the Button Visible
                }
                else{
                    Backgammon.theBoard.getTheButtons()[i].setVisible(false); // Make the Button Invisible
                }
            }
        }


    }

}

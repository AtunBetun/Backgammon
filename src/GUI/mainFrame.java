package GUI;

import GAME.Backgammon;
import GAME.Column;
import GAME.Game;
import GUI.PANELS.dicePanel;
import GUI.PANELS.moveButton;
import GUI.PANELS.welcomePanel;
import GUI.PANELS.boardPanel;
import GUI.PANELS.checkersPanel;
import GUI.PANELS.finalPieces;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame{
    private static boardPanel theBoardPanel;
    private static dicePanel theDicePanel;
    private static checkersPanel theCheckerPanel;
    private static finalPieces theScorePieces;

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

    public void updateTheMainFrame(){
        this.repaint();
        this.revalidate();
        this.validate();
    }

    public checkersPanel getTheCheckerPanel(){
        return theCheckerPanel;
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

    public static void placeCheckers() {
            theCheckerPanel = new checkersPanel();
            Backgammon.theMainFrame.getContentPane().add(theCheckerPanel);
            theCheckerPanel.repaint();

            Backgammon.theMainFrame.repaint();
            Backgammon.theMainFrame.setVisible(true);
    }

    public static void placeScorePieces() {
        theScorePieces = new finalPieces();
        Backgammon.theMainFrame.getContentPane().add(theScorePieces);
        theScorePieces.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);
    }

    public void showExistingTurnButtons(){
        System.out.println("\n## SHOW EXISTING TURN BUTTONS ##");
        if (Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN){
            for (int i = 1; i < 25; i++){

//                System.out.printf("Loop %s: ", i);
//                Backgammon.theBoard.getTheColumns()[i].printTheColumn();
//                System.out.println(" ");

                if (Backgammon.theBoard.getTheColumns()[i].getPieceCount() > 0 // If Piece Count > 0
                        && Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.WHITE){ // Column Color is white
                    System.out.printf("Column %s - Visible\n", i);

                    Backgammon.theBoard.getTheButtons()[i].setVisible(true); // Make the Button Visible
                }
                else{
//                    System.out.printf("Column %s - Invisible\n", i);
                    Backgammon.theBoard.getTheButtons()[i].setVisible(false); // Make the Button Invisible
                }
            }
        }

        if (Backgammon.theGame.getCurrentTurn() == Game.BLACK_TURN){
            for (int i = 1; i <= 24; i++){

//                System.out.printf("Loop %s: ", i);
//                Backgammon.theBoard.getTheColumns()[i].printTheColumn();
//                System.out.println(" ");

                if (Backgammon.theBoard.getTheColumns()[i].getPieceCount() > 0 // If Piece Count > 0
                        && Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.BLACK){ // Column Color is white
                    System.out.printf("Column %s - Visible\n", i);

                    Backgammon.theBoard.getTheButtons()[i].setVisible(true); // Make the Button Visible

                }
                else{
//                    System.out.printf("Column %s - Invisible\n\n", i);

                    Backgammon.theBoard.getTheButtons()[i].setVisible(false); // Make the Button Invisible
                }
            }
        }


        updateTheMainFrame();
    }

    public void showPossibleMoveButtons(){
        int selectedColumnIndex = Backgammon.theBoard.getSelectedColumn();

        System.out.printf("\n\n## Possible Move Buttons on Column %s ##\n", selectedColumnIndex);

        for(int i = 1; i <= 24; i++){

            // If the selected column has possible moves or capture pieces then set the button
            if (Backgammon.theBoard.getTheColumns()[selectedColumnIndex].getPossibleMoves()[i]
                || Backgammon.theBoard.getTheColumns()[selectedColumnIndex].getCapturePieces()[i]){
                System.out.printf("Visible %s\n", i);
                Backgammon.theBoard.getTheButtons()[i].setVisible(true);
            }

            // If there are no moves make it invisible
            else{
                Backgammon.theBoard.getTheButtons()[i].setVisible(false);
            }
        }

        Backgammon.theBoard.getTheButtons()[selectedColumnIndex].setVisible(true);

        updateTheMainFrame();


    }

}

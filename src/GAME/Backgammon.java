package GAME;

import GUI.PANELS.welcomePanel;
import GUI.mainFrame;

import javax.swing.*;

public class Backgammon {
    public static mainFrame theMainFrame;
    public static Game theGame;

    public final static String WELCOME_STATE = "welcomeState";
    public final static String START_GAME = "startGame";


    public Backgammon(){
        theMainFrame = new mainFrame();
        mainFrame.welcomeScreen(); // Calling a new welcomeScreen panel

    }

    public static void main(String[] args){
        Backgammon theGame = new Backgammon();

    }

    public static void startGame(){
        theGame = new Game();
        theGame.setGameState(START_GAME);

        mainFrame.clearTheMainFramePanels(); // Clear the JPanels on the mainFrame
        mainFrame.showDice();
        mainFrame.createEmptyBoardScreen(); // add the board JPanel to the mainFrame
    }

}

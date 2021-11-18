package GAME;

import GUI.PANELS.welcomePanel;
import GUI.mainFrame;
import GAME.*;

import javax.swing.*;

public class Backgammon {
    public static mainFrame theMainFrame;
    public static Game theGame;

    public static int whiteWins = 0;
    public static int blackWins = 0;

    public final static int WELCOME_STATE = -1;
    public final static int START_GAME = 0;
    public final static int END_GAME = 1;
    public final static long threadSleepTime = 10;

    public Backgammon(){
        theGame = new Game();
        theMainFrame = new mainFrame();
        mainFrame.welcomeScreen(); // Calling a new welcomeScreen panel

    }

    public static void main(String[] args) throws InterruptedException {
        Backgammon theBackgammon = new Backgammon();
        while (true){
            while (!theGame.getHasStarted()){ // If game has not started yet then sleep
                Thread.sleep(threadSleepTime*2);
            }
            System.out.println("Game Started!");
            while (theGame.getGameState() != END_GAME){
                // GET WHITE TURN
                // GET BLACK TURN
                theMainFrame.repaint();

            }

        }

    }

    public static void startGame(){
        theGame.setGameState(START_GAME);

        boardState theBoardState = new boardState();

        mainFrame.clearTheMainFramePanels(); // Clear the JPanels on the mainFrame
        mainFrame.createEmptyBoardScreen(); // add the board JPanel to the mainFrame

        theGame.setHasStarted(true);
    }


}

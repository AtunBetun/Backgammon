package GAME;

import GUI.PANELS.welcomePanel;
import GUI.mainFrame;

import javax.swing.*;

public class Backgammon {
    public static mainFrame theMainFrame;
    public static Game theGame;
    public static Board theBoard;

    public final static boolean GAME_HAS_STARTED = true;
    public final static boolean GAME_HAS_NOT_STARTED = false;

    public final static int WELCOME_STATE = -1;
    public final static int START_GAME = 0;
    public final static int END_GAME = 1;
    public final static long threadSleepTime = 10;

    public Backgammon() {
        theMainFrame = new mainFrame();
        theGame = new Game();
        mainFrame.welcomeScreen(); // Calling a new welcomeScreen panel
    }

    public static void main(String[] args) throws InterruptedException {
        Backgammon theBackgammon = new Backgammon(); // Start new Backgammon Object

        while (theGame.getGameState() == WELCOME_STATE) {
            Thread.sleep(threadSleepTime);
        }

        while (true) {
            while (!theGame.getHasStarted()) { // If game has not started yet then sleep
                Thread.sleep(threadSleepTime * 2);
            }
//            System.out.println("Game Started!");
            while (theGame.getGameState() != END_GAME) {

                theGame.setCurrentTurn(Game.WHITE_TURN); //Set White Turn
                theGame.setTurnStatus(Game.INCOMPLETE_TURN); //Set as Incomplete Turn

                while (theGame.getTurnStatus() != Game.COMPLETED_TURN){

                }

                // GET WHITE TURN
                // GET BLACK TURN
//                theMainFrame.repaint();

            }

        }
    }

    public static void startGame() {
        theGame = new Game();
        theGame.setGameState(START_GAME);
        theGame.setHasStarted(GAME_HAS_STARTED);
        theGame.setCurrentTurn(Game.WHITE_TURN);

        theBoard = new Board();
        theBoard.printTheColumns();

        mainFrame.clearTheMainFramePanels(); // Clear the JPanels on the mainFrame
        mainFrame.showDice();  // New Line added
        mainFrame.createEmptyBoardScreen(); // add the board JPanel to the mainFrame
    }
}

package GAME;

import GUI.PANELS.welcomePanel;
import GUI.mainFrame;

import javax.swing.*;

public class Backgammon {
    private static mainFrame theMainFrame;
    public static String gameState;
    public static String endGame;

    public final static String WELCOME_STATE = "welcomeState";
    public final static String START_GAME = "startGame";


    public Backgammon(){
        theMainFrame = new mainFrame();
        endGame = "run";
    }

    public static void main(String[] args){
        Backgammon theGame = new Backgammon();

    }


    public static void startGame(mainFrame theFrame){

    }

}

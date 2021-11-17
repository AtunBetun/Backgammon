package GAME;

import GUI.PANELS.welcomePanel;
import GUI.mainFrame;

import javax.swing.*;

public class Backgammon {
    public static mainFrame theMainFrame;


    public final static String WELCOME_STATE = "welcomeState";
    public final static String START_GAME = "startGame";


    public Backgammon(){
        Game.setGameState("run");
        theMainFrame = new mainFrame();

        mainFrame.welcomeScreen(); // Calling a new welcomeScreen panel

    }

    public static void main(String[] args){
        Backgammon theGame = new Backgammon();

    }

    public static void startGame(){
        System.out.println("Clicked Start Game Button");
    }

}

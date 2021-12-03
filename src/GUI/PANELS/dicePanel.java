package GUI.PANELS;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import GAME.Backgammon;
import GAME.Game;
import GUI.SPRITES.SpriteSheet;

public class dicePanel extends JPanel{

    public static BufferedImage dice1, dice2;
    public static int roll;
    private SpriteSheet ss = new SpriteSheet();
    public static int player;
//    private int[] diceRolls;

    public dicePanel() {
       ss.init();
       player = Game.WHITE_TURN;

//       diceRolls = new int[2];
    }

    @Override
    public void paintComponent(Graphics g) {
        int h = this.getHeight() / 2;
        Random random = new Random();
        roll = Backgammon.theBoard.getDiceRoll()[0]; // First Dice Roll
        dice1 = ss.getDie(roll);

        if(Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN) {
            g.drawImage(dice1, 700, h - 25, 60, 60, null);
            roll = Backgammon.theBoard.getDiceRoll()[1]; // Second Dice Roll

            dice2 = ss.getDie(roll);
            g.drawImage(dice2, 800, h - 25, 60, 60, null);
        }
        else if(Backgammon.theGame.getCurrentTurn() == Game.BLACK_TURN) {
            g.drawImage(dice1, 300, h - 25, 60, 60, null);
            roll = Backgammon.theBoard.getDiceRoll()[1]; // Second Dice Roll


            dice2 = ss.getDie(roll);
            g.drawImage(dice2, 400, h - 25, 60, 60, null);
        }

    }


}

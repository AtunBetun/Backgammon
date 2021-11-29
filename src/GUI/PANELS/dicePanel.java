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
    private int[] diceRolls;

    public dicePanel() {
       ss.init();
       player = Game.WHITE_TURN;

       diceRolls = new int[2];
    }

    @Override
    public void paintComponent(Graphics g) {
        int h = this.getHeight() / 2;
        Random random = new Random();
        roll = random.nextInt(1,7);
        dice1 = ss.getDie(roll);

        diceRolls[0] = roll; //First Dice Roll

        if(Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN) {
            g.drawImage(dice1, 800, h - 25, 60, 60, null);
            roll = random.nextInt(1,7);

            diceRolls[1] = roll;

            dice2 = ss.getDie(roll);
            g.drawImage(dice2, 700, h-25, 60, 60, null);
//            player++;
        }
        else if(Backgammon.theGame.getCurrentTurn() == Game.BLACK_TURN) {
            g.drawImage(dice1, 400, h - 25, 60, 60, null);
            roll = random.nextInt(1,7);

            diceRolls[1] = roll;

            dice2 = ss.getDie(roll);
            g.drawImage(dice2, 300, h - 25, 60, 60, null);
//            player--;
        }
        Backgammon.theBoard.setDiceRoll(diceRolls);

    }


}

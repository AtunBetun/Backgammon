package GUI.PANELS;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import GUI.SPRITES.SpriteSheet;

public class dicePanel extends JPanel{

    public static BufferedImage dice1, dice2;
    public static int roll;
    private SpriteSheet ss = new SpriteSheet();
    public static int player;

    public dicePanel()
    {
       ss.init();
       player = 1;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int h = this.getHeight() / 2;
        Random random = new Random();
        roll = random.nextInt(1,7);
        dice1 = ss.getDie(roll);
        if(player == 1) {
            g.drawImage(dice1, 800, h - 25, 60, 60, null);
            roll = random.nextInt(1,7);
            dice2 = ss.getDie(roll);
            g.drawImage(dice2, 700, h - 25, 60, 60, null);
            player++;
        }
        else if(player == 2)
        {
            g.drawImage(dice1, 400, h - 25, 60, 60, null);
            roll = random.nextInt(1,7);
            dice2 = ss.getDie(roll);
            g.drawImage(dice2, 300, h - 25, 60, 60, null);
            player--;
        }
    }


}

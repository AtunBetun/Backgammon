package GUI.PANELS;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import GUI.SPRITES.SpriteSheet;

public class Dice extends JPanel{

    public static BufferedImage dice1, dice2;
    private SpriteSheet ss = new SpriteSheet();

    public Dice()
    {
        ss.init();
      dice1 = ss.getDie(0);
      dice2 = ss.getDie(0);
    }

    public void start()
    {
        int h = this.getHeight() / 2;
        Dice die = new Dice();
        Graphics g = dice1.getGraphics();
        g.drawImage(die.dice1, 800, h - 25, 60, 60, null);
        g = dice2.getGraphics();
        g.drawImage(die.dice2, 700, h - 25, 60, 60, null);
    }


}

package GUI.PANELS;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import GUI.SPRITES.SpriteSheet;

public class Dice extends JPanel{

    private static BufferedImage dice1, dice2;
    private SpriteSheet ss;

    public Dice()
    {
      dice1 = ss.getDie(1);
      dice2 = ss.getDie(1);
      Graphics g = dice1.getGraphics();
      g.drawImage(dice1,100,100, (ImageObserver) this);
      g = dice2.getGraphics();
      g.drawImage(dice1,200,200, (ImageObserver) this);
    }


}

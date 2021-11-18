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
      dice1 = ss.getDie(1);
      dice2 = ss.getDie(1);
    }


}

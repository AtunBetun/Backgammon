package GUI.PANELS;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import GUI.SPRITES.SpriteSheet;
import GAME.Game;

public class finalPieces extends JPanel{
    public static BufferedImage blackFinal, whiteFinal;
    private SpriteSheet ss = new SpriteSheet();


    public finalPieces()
    {
        ss.init();
        blackFinal = ss.getBlackEnd();
        whiteFinal = ss.getWhiteEnd();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int w = (this.getWidth() / 2) - 10;
        int h = 0;
        int num = Game.getBlackScore();
        for(int i = 0; i < num; i++)
        {
            g.drawImage(blackFinal, w, h,40,15,null);
            h = h + 15;
        }
        num = Game.getWhiteScore();
        h = this.getHeight() - 15;
        for(int i = 0; i < num; i++)
        {
            g.drawImage(whiteFinal,w,h,40,15,null);
            h = h - 15;
        }
    }

}

package GUI.PANELS;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import GUI.SPRITES.SpriteSheet;
import GAME.Backgammon;

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
        int w = this.getWidth() / 2;
        int h = this.getHeight();
        int num = Backgammon.theBoard.getBlackMiddleColumn().getPieceCount();
        for(int i = 0; i < num; i++)
        {
            g.drawImage(blackFinal, w, h,40,20,null);
            h = h - 20;
        }
        num = Backgammon.theBoard.getWhiteMiddleColumn().getPieceCount();
        h = 0;
        for(int i = 0; i < num; i++)
        {
            g.drawImage(whiteFinal,w,h,40,20,null);
            h = h + 20;
        }
    }

}

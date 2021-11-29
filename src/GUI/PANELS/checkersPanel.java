package GUI.PANELS;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import GUI.SPRITES.SpriteSheet;
import GAME.Backgammon;


public class checkersPanel extends JPanel {
    public static BufferedImage blackChecker, whiteChecker;
    private SpriteSheet ss = new SpriteSheet();

    public checkersPanel() {
        ss.init();
        blackChecker = ss.getBlackChecker();
        whiteChecker = ss.getWhiteChecker();
    }

    @Override
    public void paintComponent(Graphics g) {
        int w = this.getWidth() + 35;
        for (int i = 0; i < 13; i++) {
            if (i == 7) {
                w = w - 54;
            }
            int h = this.getHeight() - 60;
            int num = Backgammon.theBoard.getTheColumns()[i].getPieceCount();
            for (int m = 0; m < num; m++) {
                if (Backgammon.theBoard.getTheColumns()[i].getThePieces().get(m).printPieceColor() == "BLACK") {
                    g.drawImage(blackChecker, w, h, 40, 40, null);
                    h = h - 30;
                } else {
                    g.drawImage(whiteChecker, w, h, 40, 40, null);
                    h = h - 30;
                }
            }
            w = w - 95;
        }
        w = 30;
        for (int i = 13; i < 25; i++) {
            if (i == 19) {
                w = w + 54;
            }
            int h = 25;
            int num = Backgammon.theBoard.getTheColumns()[i].getPieceCount();
            for (int m = 0; m < num; m++) {
                if (Backgammon.theBoard.getTheColumns()[i].getThePieces().get(m).printPieceColor() == "BLACK") {
                    g.drawImage(blackChecker, w, h, 40, 40, null);
                    h = h + 30;
                } else {
                    g.drawImage(whiteChecker, w, h, 40, 40, null);
                    h = h + 30;
                }
            }
            w = w + 95;
        }
        int n = Backgammon.theBoard.getBlackMiddleColumn().getPieceCount();
        int midWidth = (this.getWidth() / 2) - 30;
        int blackMidHeight = 440;
        int whiteMidHeight = 290;
        for(int i = 0; i < n; i++) {
            g.drawImage(blackChecker, midWidth, blackMidHeight, 40, 40, null);
            blackMidHeight = blackMidHeight - 30;
        }
        n = Backgammon.theBoard.getWhiteMiddleColumn().getPieceCount();
        for(int i = 0; i < n; i++){
            g.drawImage(whiteChecker, midWidth,whiteMidHeight,40,40,null);
            whiteMidHeight = whiteMidHeight + 30;
        }

    }
}

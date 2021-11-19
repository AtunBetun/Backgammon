package GAME;

import GAME.Backgammon;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import GUI.SPRITES.SpriteSheet;

import static GAME.Backgammon.START_GAME;
import static GAME.Backgammon.theGame;

public class Moves extends JPanel {

    public static BufferedImage blackChecker, whiteChecker;
    private SpriteSheet ss = new SpriteSheet();


    public void placeCheckers(Graphics g)
    {
        int h = this.getHeight() / 2;

        whiteChecker = ss.getWhiteChecker();
        blackChecker = ss.getBlackChecker();

        if (Objects.equals(theGame.getGameState(), START_GAME)) {
            // draw initial checkers for both players
            // g.drawImage(whiteChecker, );

        }


    }

}

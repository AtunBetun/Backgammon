package GAME;

import GAME.Backgammon;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Objects;

import GUI.SPRITES.SpriteSheet;

import static GAME.Backgammon.*;

public class Moves {
    private boolean[] possibleMoves;
    private boolean hasTurn;

    public Moves(){
        possibleMoves = new boolean[26];
        hasTurn = false;
        Arrays.fill(possibleMoves, false); // Start out the array as all false
    }

    public void setPossibleMove(int index){
        possibleMoves[index] = true;
    }
    public boolean isPossibleMove(int index){
        if (possibleMoves[index]){
            return true;
        }
        return false;
    }
    public void clearPossibleMoves(){
        Arrays.fill(possibleMoves, false);
    }

    public void computePossibleMoves(int index){
        if (theGame.getCurrentTurn() == Game.WHITE_TURN){

        }

        if (theGame.getCurrentTurn() == Game.BLACK_TURN){

        }


    }

}

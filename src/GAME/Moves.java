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
    private boolean[] capturePieces;
    private boolean hasTurn;

    public Moves(){
        possibleMoves = new boolean[26];
        capturePieces = new boolean[26];

        hasTurn = false;
        Arrays.fill(possibleMoves, false); // Start out the possible moves as all false
        Arrays.fill(capturePieces, false); // Start out the capturePieces as all false

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

    public void computeColumnPossibleMoves(int index){
        if (theGame.getCurrentTurn() == Game.WHITE_TURN){
            for (int i =  index; i > 1; i--){

                // If the column is holding 0 pieces then it is a valid move
                if (theBoard.getTheColumns()[i].pieces.size() == 0){
                    possibleMoves[i] = true;
                }
                // If the column is holding pieces of the same color then its valid
                else if(theBoard.getTheColumns()[i].getColumnColor() == Column.WHITE){
                    possibleMoves[i] = true;
                }

                else if(theBoard.getTheColumns()[i].pieces.size() == 1
                        && theBoard.getTheColumns()[i].getColumnColor() == Column.BLACK){
                    possibleMoves[i] = true;
                    capturePieces[i] = true;
                }




            }
        }

        if (theGame.getCurrentTurn() == Game.BLACK_TURN){

        }


    }

}

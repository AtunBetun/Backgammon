package GAME;

import java.util.ArrayList;

public class columnStructure {
    public static final int EMPTY = 0;
    public static final int BLACK = -1;
    public static final int WHITE = 1;

    ArrayList<Piece> pieces;

    public ArrayList<Piece> getThePieces(){
        return pieces;
    }

    public void addPiece(boolean pieceColor){
        Piece theAddedPiece = new Piece(pieceColor);
        pieces.add(theAddedPiece);
    }



}

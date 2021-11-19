package GAME;

import java.util.ArrayList;

public class Column {
    public static final int EMPTY = 0;
    public static final int BLACK = -1;
    public static final int WHITE = 1;

    private boolean columnSelected;
    private int pieceCount;
    ArrayList<Piece> pieces;

    // Default Constructor for Column()
    public Column(){
        pieces = new ArrayList<Piece>();
    }

    public ArrayList<Piece> getThePieces(){
        return pieces;
    }

    public void addPiece(boolean pieceColor){
        Piece theAddedPiece = new Piece(pieceColor);
        pieces.add(theAddedPiece);
    }

    public int getPieceCount(){
        return pieces.size();
    }

    public boolean emptyColumn(){
        if (pieces.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void selectColumn(boolean theSelection){
        columnSelected = theSelection;
    }

    public boolean getColumnSelection(){
        return columnSelected;
    }

    public Column getColumn(){
        return this;
    }

}

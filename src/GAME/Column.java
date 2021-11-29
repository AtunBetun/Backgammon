package GAME;

import java.util.ArrayList;

public class Column {
    public static final int BLACK = -1;
    public static final int WHITE = 1;

    private boolean columnSelected;
    private int columnColor;
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

    public void getColumnColor(){

    }

    public void setColumnColor(int theColor){
        columnColor = theColor;
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

    public void selectColumn(){
        if (!columnSelected){
            columnSelected = true;
        }
    }

    public boolean isSelected(){
        if (columnSelected){
            return true;
        }
        return false;
    }

    public Column getColumn(){
        return this;
    }

    public void printTheColumn(){
        for (int i = 0; i < getPieceCount(); i++){
            System.out.print(pieces.get(i).printPieceColor() + " ");
        }
    }

}

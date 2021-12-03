package GAME;

import java.util.ArrayList;

public class Column {
    public static final int BLACK = -1;
    public static final int WHITE = 1;
    public static final int EMPTY = 0;

    private boolean columnSelected;
    private int columnColor;
    private int pieceCount;
    ArrayList<Piece> pieces;
    private Moves columnMoves;

    // Default Constructor for Column()
    public Column(){
        pieces = new ArrayList<Piece>();
        columnMoves = new Moves();
    }

    public ArrayList<Piece> getThePieces(){
        return pieces;
    }
    public void addPiece(boolean pieceColor){
        Piece theAddedPiece = new Piece(pieceColor);
        pieces.add(theAddedPiece);
    }
    public void removePiece(){
        int index = pieces.size() - 1;
        pieces.remove(index);
    }

    public int getColumnColor(){
        return columnColor;
    }
    public void setColumnColor(int theColor){
        columnColor = theColor;
    }
    public int getPieceCount(){
        return pieces.size();
    }

    public void selectColumn(){
        if (!columnSelected){
//            System.out.println("Column Selected");
            columnSelected = true;
        }
    }
    public void unselectColumn(){
//        System.out.println("Column Unselected");
        columnSelected = false;
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

    public void columnComputePossibleMoves(int columnNumber){
        System.out.printf("# COLUMN COMPUTE POSSIBLE MOVES ON %s #\n", columnNumber);
        columnMoves.computeColumnPossibleMoves(columnNumber);
    }
    public void columnClearPossibleMoves(int columnNumber){
//        System.out.printf("# COLUMN CLEAR: %s #\n", columnNumber);
        columnMoves.clearPossibleMoves();
    }
    public boolean columnGetPlayerHasPossibleTurn(){
        return columnMoves.getPlayerHasPossibleTurn();
    }

    public int[] getDiceForMove(){
        return columnMoves.getDiceForMove();
    }
    public boolean[] getPossibleMoves(){
        return columnMoves.getPossibleMoves();
    }
    public boolean[] getCapturePieces(){
        return columnMoves.getCapturePieces();
    }


}

package GAME;

import GUI.PANELS.moveButton;

public class Board {
    private Column[] theColumns;
    private Column blackMiddleColumn;
    private Column whiteMiddleColumn;
    private moveButton[] theButtons;

    private boolean boardSelected;

    private int[] diceRoll;
    private int[] doubleRoll;

    public Board(){
        theColumns = new Column[26];
        theButtons = new moveButton[26];

        initializeButtons();
        initializeColumns(); // Initialize the columns
        addStartingPieces(); // addTheStartingPieces to the Board
    }

    public boolean isBoardSelected(){
        if (boardSelected){
            return true;
        }
        return false;
    }
    public void selectBoard(){
        boardSelected = true;
    }
    public void unselectBoard(){
        boardSelected = false;
    }
    public moveButton[] getTheButtons(){
        return theButtons;
    }

    public int[] getDiceRoll(){
        return diceRoll;
    }

    public void setDiceRoll(int[] theDiceRoll){
        diceRoll = theDiceRoll;
    }

    public int[] getDoubleRoll(){
        return doubleRoll;
    }

    public void setDoubleRoll(int[] theDoubleRoll){
        diceRoll = theDoubleRoll;
    }

    public Column[] getTheColumns(){
        return theColumns;
    }

    public void initializeColumns(){
        // Populate the 26 columns with the columns Object
        for(int i = 0; i < theColumns.length; i++){
            theColumns[i] = new Column();
        }
    }

    public void addStartingPieces() {

        // Column 1 - 2 White Pieces
        theColumns[1].addPiece(Piece.WHITE_PIECE); theColumns[1].addPiece(Piece.WHITE_PIECE);

        // Column 12 - 5 White Pieces
        theColumns[12].addPiece(Piece.WHITE_PIECE); theColumns[12].addPiece(Piece.WHITE_PIECE);
        theColumns[12].addPiece(Piece.WHITE_PIECE); theColumns[12].addPiece(Piece.WHITE_PIECE);
        theColumns[12].addPiece(Piece.WHITE_PIECE);

        // Column 17 - 3 White Pieces
        theColumns[17].addPiece(Piece.WHITE_PIECE); theColumns[17].addPiece(Piece.WHITE_PIECE);
        theColumns[17].addPiece(Piece.WHITE_PIECE);

        // Column 19 - 5 White Pieces
        theColumns[19].addPiece(Piece.WHITE_PIECE); theColumns[19].addPiece(Piece.WHITE_PIECE);
        theColumns[19].addPiece(Piece.WHITE_PIECE); theColumns[19].addPiece(Piece.WHITE_PIECE);
        theColumns[19].addPiece(Piece.WHITE_PIECE);

        // Column 6 - 5 Black Pieces
        theColumns[6].addPiece(Piece.BLACK_PIECE); theColumns[6].addPiece(Piece.BLACK_PIECE);
        theColumns[6].addPiece(Piece.BLACK_PIECE); theColumns[6].addPiece(Piece.BLACK_PIECE);
        theColumns[6].addPiece(Piece.BLACK_PIECE);

        // Column 8 - 3 Black Pieces
        theColumns[8].addPiece(Piece.BLACK_PIECE); theColumns[6].addPiece(Piece.BLACK_PIECE);
        theColumns[6].addPiece(Piece.BLACK_PIECE);

        // Column 13 - 5 Black Pieces
        theColumns[13].addPiece(Piece.BLACK_PIECE); theColumns[13].addPiece(Piece.BLACK_PIECE);
        theColumns[13].addPiece(Piece.BLACK_PIECE); theColumns[13].addPiece(Piece.BLACK_PIECE);
        theColumns[13].addPiece(Piece.BLACK_PIECE);

        // Column 24 - 2 Black Pieces
        theColumns[24].addPiece(Piece.BLACK_PIECE); theColumns[24].addPiece(Piece.BLACK_PIECE);
    }

    public void printTheColumns(){
        for (int i = 1; i < theColumns.length - 1; i++){
            System.out.print("Column " + i + ": ");
            theColumns[i].printTheColumn();
            System.out.println();
        }
    }

    public void initializeButtons(){
        for(int i = 0; i < theButtons.length; i++){
            theButtons[i] = new moveButton(i);
        }
    }

}

package GAME;

public class Board {
    private Column[] theColumns;
    private Column blackMiddleColumn;
    private Column whiteMiddleColumn;

    private int diceRoll[];
    private int doubleRoll[];

    public Board(){
        theColumns = new Column[26];
        initializeColumns(); // Initialize the columns
        addStartingPieces(); // addTheStartingPieces to the Board
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

    public void initializeColumns(){
        // Populate the 26 columns with the columns Object
        for(int i = 0; i < theColumns.length; i++){
            theColumns[i] = new Column();
        }
    }

    public void addStartingPieces(){

        // Column 1 - 2 White Pieces
        theColumns[1].addPiece(Piece.WHITE_PIECE); //theColumns[1].addPiece(Piece.WHITE_PIECE);

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

    }

}

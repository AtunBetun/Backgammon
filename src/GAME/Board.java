package GAME;

import GUI.PANELS.moveButton;
import GUI.PANELS.moveButtonMiddleColumn;
import GUI.PANELS.moveButtonScoreColumn;

import java.util.Random;

public class Board {
    private Column[] theColumns;
    private Column blackMiddleColumn;
    private Column whiteMiddleColumn;

    private moveButton[] theButtons;
    private moveButtonMiddleColumn blackMiddleButton;
    private moveButtonMiddleColumn whiteMiddleButton;
    private moveButtonScoreColumn whiteScoreButton, blackScoreButton;

    private boolean boardSelected;
    private int selectedColumn;

    private Random randObject;
    private int[] diceRoll;
    private int[] doubleRoll;

    private int hitOffDice;

    public static final int NO_COLUMN_SELECTED = 100;

    public Board(){
        theColumns = new Column[26];
        theButtons = new moveButton[26];
        diceRoll = new int[2];
        randObject = new Random();
        blackMiddleColumn = new Column();
        whiteMiddleColumn = new Column();

        setTheSelectedColumn(NO_COLUMN_SELECTED);

        initializeButtons();
        initializeColumns(); // Initialize the columns
        addStartingPieces(); // addTheStartingPieces to the Board
    }

    public void setHitOffDice(int theDice){
        hitOffDice = theDice;
    }
    public int getHitOffDice(){
        return hitOffDice;
    }

    public void setTheSelectedColumn(int theSelectedColumn){
        selectedColumn = theSelectedColumn;
    }
    public int getSelectedColumn(){
        return selectedColumn;
    }

    public boolean isBoardSelected(){
        if (boardSelected){
            return true;
        }
        return false;
    }
    public void selectBoard(){
//        System.out.println("Board Selected");
        boardSelected = true;
    }
    public void unselectBoard(){
//        System.out.println("Board Unselected");
        boardSelected = false;
    }

    public int[] getDiceRoll(){
        return diceRoll;
    }
    public void setDiceRollArray(int[] theDiceRoll){
        diceRoll = theDiceRoll;
    }
    public void rollTheDice(){
        diceRoll[0] = randObject.nextInt(1, 7);
        diceRoll[1] = randObject.nextInt(1,7);

        // No Doubles for now
        while(diceRoll[0] == diceRoll[1]){
            diceRoll[1] = randObject.nextInt(1,7);
        }

        System.out.printf("\n\n## DICE ROLL dice1: %s  dice2: %s ##\n\n", diceRoll[0], diceRoll[1]);
    }
    public void setFirstDiceRoll(int firstDiceRoll){
        diceRoll[0] = firstDiceRoll;
    }
    public void setSecondDiceRoll(int secondDiceRoll){
        diceRoll[1] = secondDiceRoll;
    }

    public int[] getDoubleRoll(){
        return doubleRoll;
    }
    public void setDoubleRoll(int[] theDoubleRoll){
        diceRoll = theDoubleRoll;
    }

    public Column getBlackMiddleColumn(){
        return blackMiddleColumn;
    }
    public Column getWhiteMiddleColumn(){
        return whiteMiddleColumn;
    }


    public void printTheColumns(){
        for (int i = 1; i < theColumns.length - 1; i++){
            System.out.print("Column " + i + ": ");
            theColumns[i].printTheColumn();
            System.out.println();
        }

        System.out.print("BlackMiddleColumn: ");
        blackMiddleColumn.printTheColumn();
        System.out.println();

        System.out.print("WhiteMiddleColumn: ");
        whiteMiddleColumn.printTheColumn();
        System.out.println();
    }
    public Column[] getTheColumns(){
        return theColumns;
    }

    public void initializeColumns(){
        // Populate the 26 columns with the columns Object
        for(int i = 0; i < theColumns.length; i++){
            theColumns[i] = new Column();
        }

        blackMiddleColumn = new Column(); // Empty black Middle Column
        whiteMiddleColumn = new Column(); // Emppty white Middle Column
    }
    public void addStartingPieces() {

        // Column 1 - 2 White Pieces
        theColumns[1].addPiece(Piece.WHITE_PIECE); theColumns[1].addPiece(Piece.WHITE_PIECE);
        theColumns[1].setColumnColor(Column.WHITE); // Column Color

        // Column 12 - 5 White Pieces
        theColumns[12].addPiece(Piece.WHITE_PIECE); theColumns[12].addPiece(Piece.WHITE_PIECE);
        theColumns[12].addPiece(Piece.WHITE_PIECE); theColumns[12].addPiece(Piece.WHITE_PIECE);
        theColumns[12].addPiece(Piece.WHITE_PIECE);
        theColumns[12].setColumnColor(Column.WHITE); // Column Color

        // Column 17 - 3 White Pieces
        theColumns[17].addPiece(Piece.WHITE_PIECE); theColumns[17].addPiece(Piece.WHITE_PIECE);
        theColumns[17].addPiece(Piece.WHITE_PIECE);
        theColumns[17].setColumnColor(Column.WHITE); // Column Color

        // Column 19 - 5 White Pieces
        theColumns[19].addPiece(Piece.WHITE_PIECE); theColumns[19].addPiece(Piece.WHITE_PIECE);
        theColumns[19].addPiece(Piece.WHITE_PIECE); theColumns[19].addPiece(Piece.WHITE_PIECE);
        theColumns[19].addPiece(Piece.WHITE_PIECE);
        theColumns[19].setColumnColor(Column.WHITE); // Column Color

        // Column 6 - 5 Black Pieces
        theColumns[6].addPiece(Piece.BLACK_PIECE); theColumns[6].addPiece(Piece.BLACK_PIECE);
        theColumns[6].addPiece(Piece.BLACK_PIECE); theColumns[6].addPiece(Piece.BLACK_PIECE);
        theColumns[6].addPiece(Piece.BLACK_PIECE);
        theColumns[6].setColumnColor(Column.BLACK); // Column Color

        // Column 8 - 3 Black Pieces
        theColumns[8].addPiece(Piece.BLACK_PIECE); theColumns[8].addPiece(Piece.BLACK_PIECE);
        theColumns[8].addPiece(Piece.BLACK_PIECE);
        theColumns[8].setColumnColor(Column.BLACK); // Column Color

        // Column 13 - 5 Black Pieces
        theColumns[13].addPiece(Piece.BLACK_PIECE); theColumns[13].addPiece(Piece.BLACK_PIECE);
        theColumns[13].addPiece(Piece.BLACK_PIECE); theColumns[13].addPiece(Piece.BLACK_PIECE);
        theColumns[13].addPiece(Piece.BLACK_PIECE);
        theColumns[13].setColumnColor(Column.BLACK); // Column Color

        // Column 24 - 2 Black Pieces
        theColumns[24].addPiece(Piece.BLACK_PIECE); theColumns[24].addPiece(Piece.BLACK_PIECE);
        theColumns[24].setColumnColor(Column.BLACK); // Column Color

        blackMiddleColumn.setColumnColor(Column.BLACK);
        whiteMiddleColumn.setColumnColor(Column.WHITE);
    }

    public moveButton[] getTheButtons(){
        return theButtons;
    }
    public void initializeButtons(){
        for(int i = 0; i < theButtons.length; i++){
            theButtons[i] = new moveButton(i);
        }
        blackMiddleButton = new moveButtonMiddleColumn(moveButtonMiddleColumn.BLACK_MIDDLE_BUTTON);
        whiteMiddleButton = new moveButtonMiddleColumn(moveButtonMiddleColumn.WHITE_MIDDLE_BUTTON);
        blackScoreButton = new moveButtonScoreColumn(moveButtonScoreColumn.BLACK_SCORE_BUTTON);
        whiteScoreButton = new moveButtonScoreColumn(moveButtonScoreColumn.WHITE_SCORE_BUTTON);
    }
    public moveButtonMiddleColumn getBlackMiddleButton(){
        return blackMiddleButton;
    }
    public moveButtonMiddleColumn getWhiteMiddleButton(){
        return whiteMiddleButton;
    }
    public moveButtonScoreColumn getBlackScoreButton() {return blackScoreButton;}
    public moveButtonScoreColumn getWhiteScoreButton(){return whiteScoreButton;}

}

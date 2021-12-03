package GUI.PANELS;

import GAME.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class moveButton extends JButton {
    private int theColumnNumber;
    public final int CONSUMED_DICE = 0;
    public final int[] COMBINED_CONSUMED_DICE = {0, 0};

    private boolean turnPieceColor;
    private boolean oppositePieceColor;


    public moveButton(int columnNumber){

        // Initial Formatting
        this.theColumnNumber = columnNumber;
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new LineBorder(Color.WHITE, 1));
        this.setText(String.valueOf(theColumnNumber));
        this.setFont(new Font("Calibri", Font.BOLD, 15));
        this.setForeground(Color.BLACK);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.HORIZONTAL);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("\nButton %s\n", theColumnNumber);

                setThePieceColorForButton();

                // Select a column
                if (!Backgammon.theBoard.isBoardSelected() // Check that the board is NOT Selected
                        && !Backgammon.theBoard.getTheColumns()[theColumnNumber].isSelected()  // Check that the column is NOT selected
                        && Backgammon.theBoard.getTheColumns()[theColumnNumber].getPieceCount() > 0){ // Piece count is > 0

                    System.out.println("## SELECTING A COLUMN ##");

                    Backgammon.theBoard.getTheColumns()[theColumnNumber].selectColumn(); //Select the column on Column Class
                    Backgammon.theBoard.selectBoard(); // Board is currently selected
                    Backgammon.theBoard.setTheSelectedColumn(theColumnNumber); // Set the Board's selected column

                    Backgammon.theMainFrame.showPossibleMoveButtons();

                }

                // Unselect a column
                else if (Backgammon.theBoard.isBoardSelected() // Board is selected
                        && Backgammon.theBoard.getTheColumns()[theColumnNumber].isSelected() // The Column is selected
                        && Backgammon.theBoard.getSelectedColumn() == theColumnNumber){ // theBoard's selected column is selected

                    System.out.println("## UNSELECTING A COLUMN ##");

                    Backgammon.theBoard.getTheColumns()[theColumnNumber].unselectColumn(); // Unselect the column Class
                    Backgammon.theBoard.unselectBoard(); // Unselected the Board
                    Backgammon.theBoard.setTheSelectedColumn(Board.NO_COLUMN_SELECTED); // Set the selected column as N/A

                    Backgammon.theMainFrame.showExistingTurnButtons();
                }

                // Move Execution
                else if (
                        Backgammon.theBoard.isBoardSelected() // Board is Selected
                        && Backgammon.theBoard.getSelectedColumn() != theColumnNumber // The initial selected column was NOT this
                        && (    // The now chosen piece is either a valid capturable column or possible column
                            Backgammon.theBoard.getTheColumns()[Backgammon.theBoard.getSelectedColumn()].getCapturePieces()[theColumnNumber]
                            || Backgammon.theBoard.getTheColumns()[Backgammon.theBoard.getSelectedColumn()].getPossibleMoves()[theColumnNumber]
                            )
                        )
                {

                    int boardSelectedColumn = Backgammon.theBoard.getSelectedColumn();

                    System.out.println("## MOVE EXECUTION ##");

                    consumeDice(); // Consume the dice used for the turn
                    executeTurn(); // Execute the turn

                    // If both dice have been consumed then finish the turn
                    if (Backgammon.theBoard.getDiceRoll()[0] == 0 && Backgammon.theBoard.getDiceRoll()[1] == 0){
                        Backgammon.theGame.setTurnStatus(Game.COMPLETED_TURN); // Completed Turn
                    }

                    Backgammon.theMainFrame.showExistingTurnButtons(); // Go back to showing the existing turn buttons

                    Backgammon.theBoard.unselectBoard(); // Unselect the board
                    Backgammon.theBoard.getTheColumns()[boardSelectedColumn].unselectColumn(); // Unselect original column
                    Backgammon.theBoard.setTheSelectedColumn(Board.NO_COLUMN_SELECTED); // the Board has no column selected

                    Backgammon.theGame.gameComputePossibleMoves(); // Compute the possible moves on the columns

                    Backgammon.theMainFrame.updateTheMainFrame();

                }

            }
        });
    }

    public void consumeDice(){
        int boardSelectedColumn = Backgammon.theBoard.getSelectedColumn();
        int theDiceUsed = Backgammon.theBoard.getTheColumns()[boardSelectedColumn].getDiceForMove()[theColumnNumber];

        if (theDiceUsed == Moves.FIRST_DICE){
            Backgammon.theBoard.setFirstDiceRoll(CONSUMED_DICE);
        }

        else if(theDiceUsed == Moves.SECOND_DICE){
            Backgammon.theBoard.setSecondDiceRoll(CONSUMED_DICE);
        }

        else if (theDiceUsed == Moves.COMBINED_DICE){
            Backgammon.theBoard.setFirstDiceRoll(CONSUMED_DICE);
            Backgammon.theBoard.setSecondDiceRoll(CONSUMED_DICE);
        }

    }

    public void executeTurn(){
        int boardSelectedColumn = Backgammon.theBoard.getSelectedColumn();

        //Remove piece from the board selected column
        Backgammon.theBoard.getTheColumns()[boardSelectedColumn].removePiece(); // Remove the piece from the boardSelectedColumn
        if (Backgammon.theBoard.getTheColumns()[boardSelectedColumn].getThePieces().size() == 0){
            Backgammon.theBoard.getTheColumns()[boardSelectedColumn].setColumnColor(Column.EMPTY);
        }

        // Captured Column
        if (Backgammon.theBoard.getTheColumns()[boardSelectedColumn].getCapturePieces()[theColumnNumber]){
            System.out.printf(" ## CAPTURING: %s ----  FROM: %s ##\n", theColumnNumber, boardSelectedColumn);

            Backgammon.theBoard.getTheColumns()[theColumnNumber].removePiece(); // Remove the captured piece
            Backgammon.theBoard.getTheColumns()[theColumnNumber].addPiece(turnPieceColor); // Add a piece from the new color
            addPieceToMiddleColumn(); // Add piece to the middle column from the opponent

            // Set the Column Color
            if (turnPieceColor == Piece.WHITE_PIECE){
                Backgammon.theBoard.getTheColumns()[theColumnNumber].setColumnColor(Column.WHITE);
            }
            else if (turnPieceColor == Piece.BLACK_PIECE){
                Backgammon.theBoard.getTheColumns()[theColumnNumber].setColumnColor(Column.BLACK);
            }

        }

        // Moving to another column
        else if(Backgammon.theBoard.getTheColumns()[boardSelectedColumn].getPossibleMoves()[theColumnNumber]){
            System.out.printf("# MOVING: %s ----  FROM: %s ##\n", theColumnNumber, boardSelectedColumn);
            // Check if the column to add the pieces is empty
            if (Backgammon.theBoard.getTheColumns()[theColumnNumber].getColumnColor() == Column.EMPTY
                && Backgammon.theBoard.getTheColumns()[theColumnNumber].getThePieces().size() == 0){

                System.out.printf("# EMPTY COLUMN: %s -> COLOR:", theColumnNumber);

                // Set the Column color
                if (turnPieceColor == Piece.WHITE_PIECE){
                    System.out.print(" WHITE #\n");
                    Backgammon.theBoard.getTheColumns()[theColumnNumber].setColumnColor(Column.WHITE);
                }
                else{
                    System.out.print(" BLACK #\n");
                    Backgammon.theBoard.getTheColumns()[theColumnNumber].setColumnColor(Column.BLACK);
                }
            }

            // Add the new piece to the column
            Backgammon.theBoard.getTheColumns()[theColumnNumber].addPiece(turnPieceColor);

        }


    }

    public void addPieceToMiddleColumn(){
        // White turn so the column added will be to the black
        if (Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN){
            Backgammon.theBoard.getBlackMiddleColumn().addPiece(Piece.BLACK_PIECE);
        }
        else{
            Backgammon.theBoard.getWhiteMiddleColumn().addPiece(Piece.WHITE_PIECE);
        }

    }

    public void setThePieceColorForButton(){
        if (Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN){
            turnPieceColor = Piece.WHITE_PIECE;
            oppositePieceColor = Piece.BLACK_PIECE;
        }
        else{
            turnPieceColor = Piece.BLACK_PIECE;
            oppositePieceColor = Piece.WHITE_PIECE;
        }
    }

}

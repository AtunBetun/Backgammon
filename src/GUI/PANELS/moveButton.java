package GUI.PANELS;

import GAME.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class moveButton extends JButton {
    private int theColumnNumber;

    public moveButton(int columnNumber){
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

                boolean thePieceColor;
                if (Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN){
                    thePieceColor = Piece.WHITE_PIECE;
                }
                else{
                    thePieceColor = Piece.BLACK_PIECE;
                }

                System.out.printf("\nButton %s\n", theColumnNumber);

                // Select a column
                if (!Backgammon.theBoard.isBoardSelected() // Check that the board is NOT Selected
                        && !Backgammon.theBoard.getTheColumns()[theColumnNumber].isSelected()  // Check that the column is NOT selected
                        && Backgammon.theBoard.getTheColumns()[theColumnNumber].getPieceCount() > 0){ // Piece count is > 0

                    System.out.println("## SELECTING A COLUMN ##");

                    Backgammon.theBoard.getTheColumns()[theColumnNumber].selectColumn(); //Select the column on Column Class
                    Backgammon.theBoard.selectBoard(); // Board is currently selected
                    Backgammon.theBoard.setTheSelectedColumn(theColumnNumber); // Set the Board's selected column
                }

                // Unselect a column
                else if (Backgammon.theBoard.isBoardSelected() // Board is selected
                        && Backgammon.theBoard.getTheColumns()[theColumnNumber].isSelected() // The Column is selected
                        && Backgammon.theBoard.getSelectedColumn() == theColumnNumber){ // theBoard's selected column is selected

                    System.out.println("## UNSELECTING A COLUMN ##");

                    Backgammon.theBoard.getTheColumns()[theColumnNumber].unselectColumn(); // Unselect the column Class
                    Backgammon.theBoard.unselectBoard(); // Unselected the Board
                    Backgammon.theBoard.setTheSelectedColumn(Board.NO_COLUMN_SELECTED); // Set the selected column as N/A
                }

                // Move to piece to another column
                else if (Backgammon.theBoard.isBoardSelected()
                        && Backgammon.theBoard.getSelectedColumn() != theColumnNumber)
                        // && this is a possible move
                        {

                    System.out.println("## MOVE PIECE ##");

                    //Remove piece from the board selected column
                    Backgammon.theBoard.getTheColumns()[Backgammon.theBoard.getSelectedColumn()].removePiece();
                    Backgammon.theBoard.getTheColumns()[theColumnNumber].addPiece(thePieceColor); // Add a piece to the selected column

                    Backgammon.theBoard.unselectBoard(); // Unselect the board
                    Backgammon.theBoard.getTheColumns()[Backgammon.theBoard.getSelectedColumn()].unselectColumn(); // Unselect original column
                    Backgammon.theBoard.setTheSelectedColumn(Board.NO_COLUMN_SELECTED); // the Board has no column selected

                    Backgammon.theGame.setTurnStatus(Game.COMPLETED_TURN); // Completed Turn
                }



            }
        });
    }

}

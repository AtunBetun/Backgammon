package GUI.PANELS;

import GAME.Backgammon;
import GAME.Column;
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

                System.out.printf("Clicked the button %s\n", theColumnNumber);
                System.out.print("The column contains: ");
                Backgammon.theBoard.getTheColumns()[theColumnNumber].printTheColumn();
                System.out.println("");

                if (!Backgammon.theBoard.isBoardSelected()      // Check that the board is NOT Selected
                        && !Backgammon.theBoard.getTheColumns()[theColumnNumber].isSelected()  // Check that the column is NOT selected
                        && Backgammon.theBoard.getTheColumns()[theColumnNumber].getPieceCount() > 0){ // Piece count is > 0

                    Backgammon.theBoard.getTheColumns()[theColumnNumber].selectColumn(); //Select the column on the move button
                    Backgammon.theBoard.selectBoard();
                }

            }
        });
    }

}

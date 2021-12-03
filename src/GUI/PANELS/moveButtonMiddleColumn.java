package GUI.PANELS;

import GAME.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class moveButtonMiddleColumn extends JButton {

    public static final String BLACK_MIDDLE_BUTTON = "B";
    public static final String WHITE_MIDDLE_BUTTON = "W";

    public moveButtonMiddleColumn(String buttonName){
        int buttonColor;

        if (buttonName == BLACK_MIDDLE_BUTTON){
            buttonColor = Column.BLACK;
        }
        if (buttonName == WHITE_MIDDLE_BUTTON){
            buttonColor = Column.WHITE;
        }

        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new LineBorder(Color.WHITE, 1));
        this.setText(String.valueOf(buttonName));
        this.setFont(new Font("Calibri", Font.BOLD, 15));
        this.setForeground(Color.BLACK);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.HORIZONTAL);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Backgammon.theGame.setHitOff(Game.CAN_HIT_OFF);

                if (Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN){

                    boolean possibleHitOff = false;

                    for (int i = 6; i >=1; i--){
                        if (Backgammon.theBoard.getTheColumns()[i].getThePieces().size() == 0
                                || Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.WHITE){

                            // First dice roll clean
                            if (Backgammon.theBoard.getDiceRoll()[0] == i){
                                Backgammon.theBoard.getTheButtons()[i].setVisible(true);
                                Backgammon.theBoard.setHitOffDice(Moves.FIRST_DICE);
                                possibleHitOff = true;
                            }

                            // Second dice roll clean
                            else if (Backgammon.theBoard.getDiceRoll()[1] == i){
                                Backgammon.theBoard.getTheButtons()[i].setVisible(true);
                                Backgammon.theBoard.setHitOffDice(Moves.SECOND_DICE);
                                possibleHitOff = true;
                            }

                            // Combined dice roll clean
                            else if (Backgammon.theBoard.getDiceRoll()[0] + Backgammon.theBoard.getDiceRoll()[1] == i){
                                Backgammon.theBoard.getTheButtons()[i].setVisible(true);
                                Backgammon.theBoard.setHitOffDice(Moves.COMBINED_DICE);
                                possibleHitOff = true;
                            }

                        }
                    }

                    if (!possibleHitOff){
                        Backgammon.theGame.setTurnStatus(Game.COMPLETED_TURN);
                        Backgammon.theGame.setHitOff(Game.NO_HIT_OFF);
                    }


                }

                else if (Backgammon.theGame.getCurrentTurn() == Game.BLACK_TURN){

                    boolean possibleHitOff = false;

                    for (int i = 24; i >=19; i--){
                        if (Backgammon.theBoard.getTheColumns()[i].getThePieces().size() == 0
                                || Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.BLACK){

                            // First dice roll clean
                            if (Backgammon.theBoard.getDiceRoll()[0] == 25 - i){
                                Backgammon.theBoard.getTheButtons()[i].setVisible(true);
                                Backgammon.theBoard.setHitOffDice(Moves.FIRST_DICE);
                                possibleHitOff = true;
                            }

                            // Second dice roll clean
                            else if (Backgammon.theBoard.getDiceRoll()[1] == 25 - i){
                                Backgammon.theBoard.getTheButtons()[i].setVisible(true);
                                Backgammon.theBoard.setHitOffDice(Moves.SECOND_DICE);
                                possibleHitOff = true;
                            }

                            else if (Backgammon.theBoard.getDiceRoll()[0] + Backgammon.theBoard.getDiceRoll()[1] == i){
                                Backgammon.theBoard.getTheButtons()[i].setVisible(true);
                                Backgammon.theBoard.setHitOffDice(Moves.COMBINED_DICE);
                                possibleHitOff = true;
                            }

                        }
                    }

                    if (!possibleHitOff){
                        Backgammon.theGame.setTurnStatus(Game.COMPLETED_TURN);
                        Backgammon.theGame.setHitOff(Game.NO_HIT_OFF);
                    }

                }

                Backgammon.theMainFrame.updateTheMainFrame();

            }

        });
    }

}

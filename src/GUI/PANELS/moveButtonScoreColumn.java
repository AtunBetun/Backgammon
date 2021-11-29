package GUI.PANELS;
import GAME.Column;
import GAME.Game;
import GAME.Piece;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class moveButtonScoreColumn extends JButton {

    public static final String BLACK_SCORE_BUTTON = "BS";
    public static final String WHITE_SCORE_BUTTON = "WS";

    public moveButtonScoreColumn(String buttonName) {
        int buttonColor;

        if (buttonName == BLACK_SCORE_BUTTON) {
            buttonColor = Column.BLACK;
        }
        if (buttonName == WHITE_SCORE_BUTTON) {
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
               // System.out.printf("Score Button %s\n", buttonName);
                if(buttonName == BLACK_SCORE_BUTTON)
                {
                    //System.out.printf("Black Score Button \n");
                    Game.increaseBlackScore();
                }
                else if(buttonName == WHITE_SCORE_BUTTON)
                {
                    //System.out.printf("White Score Button \n");
                    Game.increaseWhiteScore();
                }
                System.out.printf("Black Score: %d \n", Game.getBlackScore());
                System.out.printf("White Score: %d \n",Game.getWhiteScore());
                System.out.printf("\n");

            }
        });

    }
}

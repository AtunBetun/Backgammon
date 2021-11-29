package GUI.PANELS;

import GAME.Board;
import GAME.Column;

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
                System.out.printf("Middle Button %s\n", buttonName);
            }
        });
    }

}

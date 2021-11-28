package GUI.PANELS;

import GAME.Backgammon;
import GAME.Column;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class moveButton extends JButton {
    private int theColumnNumber;

    public moveButton(int columnNumber){
        this.theColumnNumber = columnNumber;

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Select a Column
            }
        });
    }

}

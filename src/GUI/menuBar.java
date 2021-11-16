package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JMenuBar {
    public menuBar(){
        JMenu gameMenu = new JMenu("Game");
        this.add(gameMenu);

        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // The options window goes here

            }
        });
        gameMenu.add(newGameMenuItem);

        JMenu optionsMenu = new JMenu("Options");
        this.add(optionsMenu);
        JMenuItem exitGameMenuItem = new JMenuItem("Exit");
        exitGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        optionsMenu.add(exitGameMenuItem);

    }

}

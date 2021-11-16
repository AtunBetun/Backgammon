package GUI.OPTIONS;

import javax.swing.*;

public class gameOptionsFrame extends JFrame {
    static final String LOCALGAME = "Local Game";

    public gameOptionsFrame(){
        super("New Game Settings");
        this.setSize(400, 200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

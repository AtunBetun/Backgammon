package GUI.OPTIONS;

import GUI.*;
import javax.swing.*;
import java.awt.event.WindowEvent;

public class gameOptionsFrame extends JFrame {
    static final String LOCAL_HUMANS = "Local Game";

    public gameOptionsFrame(){
        super("New Game Settings");
        this.setSize(400, 300);

        JPanel theLocalGamePanel = new localGamePanel(this);

        JTabbedPane gameModes = new JTabbedPane();
        gameModes.add("Local Game", theLocalGamePanel);

        this.add(gameModes);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void closeGameOptionsFrame(gameOptionsFrame theGameOptionsFrame){
        theGameOptionsFrame.dispatchEvent(new WindowEvent(theGameOptionsFrame, WindowEvent.WINDOW_CLOSING));
    }
}

package GUI;

import GAME.Backgammon;
import GUI.PANELS.welcomePanel;
import GUI.PANELS.boardPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mainFrame extends JFrame{

    public mainFrame(){
        super("Backgammon");

        // menuBar added onto the mainFrame
        GUI.menuBar theMenuBar = new menuBar();
        this.setJMenuBar(theMenuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setResizable(false);
        this.setVisible(true);

    }

    public static void welcomeScreen(){
        welcomePanel theWelcomePanel = new welcomePanel();
        Backgammon.theMainFrame.getContentPane().add(theWelcomePanel);
        theWelcomePanel.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);
    }

    public static void createEmptyBoardScreen(){
        boardPanel emptyBoardPanel = new boardPanel();
        Backgammon.theMainFrame.getContentPane().add(emptyBoardPanel);
        emptyBoardPanel.repaint();

        Backgammon.theMainFrame.repaint();
        Backgammon.theMainFrame.setVisible(true);
    }

    public static void clearTheMainFramePanels(){
        Backgammon.theMainFrame.getContentPane().removeAll();
        Backgammon.theMainFrame.repaint();
    }

}

class PaintMouseListener implements MouseListener{

    JComponent component;

    public PaintMouseListener(JComponent component) {
        this.component = component;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        component.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        component.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        component.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        component.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        component.repaint();
    }

}

class PaintMouseMotionListener implements MouseMotionListener{

    JComponent component;

    public PaintMouseMotionListener(JComponent component) {
        this.component = component;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        component.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        component.repaint();
    }

}
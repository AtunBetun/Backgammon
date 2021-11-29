package GUI.PANELS;

import GAME.Backgammon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class boardPanel extends JPanel {

//    final static int[][] BUTTON_LOCATIONS = {{1,2},};

    public boardPanel() {
        // THE BACKGROUND IS NOT WORKING AFTER IMPORTING TO MASTER
//        Color back = new Color(153,102,0);
//        this.setBackground(back);
    }

    @Override
    public void paintComponent(Graphics g) {
        int topx = 49, topy = 325, botx1 = 4, botx2 = 95;
        Graphics2D g2 = (Graphics2D) g.create();
        Color c = new Color(102,51,0);
        Color back = new Color(153,102,0);
        g2.setColor(back);
        g2.fillRect(0,0,this.getWidth(),this.getHeight());
        g2.setColor(c);
        g2.fillRect(575,0,50,1200);
        for(int i = 2; i < 14; i++) {
            if(i == 8) {
                botx1 = botx1 + 54;
                botx2 = botx2 + 54;
                topx = topx + 56;
            }

            GeneralPath triangle = new GeneralPath();
            triangle.moveTo(topx,topy);
            triangle.lineTo(botx2,0);
            triangle.lineTo(botx1,0);
            triangle.closePath();

            if(i % 2 != 0) {
                g2.setColor(Color.BLACK);
                g2.fill(triangle);
                botx1 = botx1 + 95;
                botx2 = botx2 + 95;
                topx = topx + 94;
            }

            else {
                g2.setColor(Color.WHITE);
                g2.fill(triangle);
                botx1 = botx1 + 95;
                botx2 = botx2 + 95;
                topx = topx + 94;
            }
        }

        topy = 425;
        botx1 = 4;
        botx2 = 95;
        topx = 49;

        for(int i = 2; i < 14; i++) {
            if(i == 8) {
                botx1 = botx1 + 54;
                botx2 = botx2 + 54;
                topx = topx + 56;
            }

            GeneralPath triangle = new GeneralPath();
            triangle.moveTo(topx,topy);
            triangle.lineTo(botx2,800);
            triangle.lineTo(botx1,800);
            triangle.closePath();

            if(i % 2 != 0) {
                g2.setColor(Color.WHITE);
                g2.fill(triangle);
                botx1 = botx1 + 95;
                botx2 = botx2 + 95;
                topx = topx + 94;
            }

            else {
                g2.setColor(Color.BLACK);
                g2.fill(triangle);
                botx1 = botx1 + 95;
                botx2 = botx2 + 95;
                topx = topx + 94;
            }

        }


    }

    public void addMoveButtons(){
        int x, y;

        // Upper Right Quadrant
        x = 1130;
        y = 0;
        for (int i = Backgammon.theBoard.getTheButtons().length - 2; i >= Backgammon.theBoard.getTheButtons().length - Backgammon.theBoard.getTheButtons().length/4 - 1; i--){
            Backgammon.theBoard.getTheButtons()[i].setBounds(x, y, 35, 20);
            x -= 95;
            Backgammon.theMainFrame.getTheBoardPanel().add(Backgammon.theBoard.getTheButtons()[i]);
        }

        x = 505;
        y = 0;
        // Upper Left Quadrant
        for (int i = Backgammon.theBoard.getTheButtons().length - 8; i >= 10; i--){
            Backgammon.theBoard.getTheButtons()[i].setBounds(x, y, 35, 20);
            x -= 95;
            Backgammon.theMainFrame.getTheBoardPanel().add(Backgammon.theBoard.getTheButtons()[i]);
        }

        x = 1130;
        y = 720;
        // Down Right Quadrant
        for (int i = 1; i < 7; i++){
            Backgammon.theBoard.getTheButtons()[i].setBounds(x, y, 35, 20);
            x -= 95;
            Backgammon.theMainFrame.getTheBoardPanel().add(Backgammon.theBoard.getTheButtons()[i]);
        }

        x = 505;
        y = 720;
        // Down Left Quadrant
        for (int i = 7; i < 13; i++){
            Backgammon.theBoard.getTheButtons()[i].setBounds(x, y, 35, 20);
            x -= 95;
            Backgammon.theMainFrame.getTheBoardPanel().add(Backgammon.theBoard.getTheButtons()[i]);
        }

        Backgammon.theBoard.getBlackMiddleButton().setBounds(600, 480, 35, 20);
        Backgammon.theMainFrame.getTheBoardPanel().add(Backgammon.theBoard.getBlackMiddleButton());
        Backgammon.theBoard.getBlackMiddleButton().setVisible(true);

        Backgammon.theBoard.getWhiteMiddleButton().setBounds(600, 250, 35, 20);
        Backgammon.theMainFrame.getTheBoardPanel().add(Backgammon.theBoard.getWhiteMiddleButton());
        Backgammon.theBoard.getWhiteMiddleButton().setVisible(true);
    }


}
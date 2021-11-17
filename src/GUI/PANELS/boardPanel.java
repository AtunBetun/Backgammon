package GUI.PANELS;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class boardPanel extends JPanel {

    public boardPanel() {
        // boardPanel theBoard = new boardPanel();
    }

    @Override
    public void paintComponent(Graphics g) {
        int topx = 49, topy = 325, botx1 = 4, botx2 = 95;
        Graphics2D g2 = (Graphics2D) g.create();
        Color c = new Color(102,51,0);
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


}
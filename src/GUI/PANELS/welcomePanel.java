package GUI.PANELS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static GUI.OPTIONS.localGamePanel.resizeBufferedImage;

public class welcomePanel extends JPanel {

    private BufferedImage backgammonGameLogo;

    public welcomePanel(){
        this.getImages();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphicsObject = (Graphics2D) g;
        graphicsObject.translate(this.getWidth() / 2, this.getHeight() / 2);
        graphicsObject.translate(-backgammonGameLogo.getWidth(null) / 2, -backgammonGameLogo.getHeight(null) / 2);
        graphicsObject.drawImage(backgammonGameLogo, 0, 0, null);
    }

    public void getImages(){
        try{
            backgammonGameLogo = ImageIO.read(new File("src/RESOURCES/backgammonGameLogo.png"));
            backgammonGameLogo = resizeBufferedImage(backgammonGameLogo, 1200, 500);

        }
        catch (IOException ex){
            System.out.println("IO Exception catched when getting images\n Ending program");
            System.exit(1);
        }
    }

}

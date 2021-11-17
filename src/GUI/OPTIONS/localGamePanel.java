package GUI.OPTIONS;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class localGamePanel extends JPanel {

    private BufferedImage backgammonIcon;
    private ImageIcon startButtonImage;

    public localGamePanel(){
        this.getImages(); // Get the images from the resources

        JButton localGameStartButton = new JButton(); // the Start Button
        localGameStartButton.setIcon(startButtonImage); // Adding the image
        localGameStartButton.setFocusable(false);

        localGameStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ADD THE START GAME FUNCTION HERE
            }
        });

        this.setBackground(Color.lightGray);
        this.add(localGameStartButton);

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphicsObject = (Graphics2D)g;

        int height, width;
        height = getHeight();
        width = getWidth();

        g.drawImage(backgammonIcon, 0, 0, this);
    }

    public void getImages(){
        try{
            backgammonIcon = ImageIO.read(new File("src/RESOURCES/backgammonIcon.png"));
            backgammonIcon = resizeBufferedImage(backgammonIcon, 30, 30);

            startButtonImage = new ImageIcon("src/RESOURCES/startButton.png"); // Original Start Image Icon
            startButtonImage = resizeImageIcon(startButtonImage, 120, 80); // Resized Image Icon
        }
        catch (IOException ex){

        }
    }

    // Stack Overflow function for resizing the ImageIcon
    // https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    public static ImageIcon resizeImageIcon(ImageIcon icon, int w, int h) {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w) {
            nw = w;
            nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }

    public static BufferedImage resizeBufferedImage(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}



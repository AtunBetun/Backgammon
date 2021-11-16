package GUI.OPTIONS;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class localGamePanel extends JPanel {

    public localGamePanel(){
        ImageIcon startButtonImage = new ImageIcon("src/RESOURCES/startButton.png"); // Original Start Image Icon
        ImageIcon resizedStartButton = scaleImage(startButtonImage, 120, 80); // Resized Image Icon

        JButton localGameStartButton = new JButton(); // the Start Button
        localGameStartButton.setIcon(resizedStartButton); // Adding the image
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

    // Stack Overflow function for resizing the ImageIcon
    // https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    public static ImageIcon scaleImage(ImageIcon icon, int w, int h) {
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

}

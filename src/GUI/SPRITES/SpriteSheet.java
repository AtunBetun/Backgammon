package GUI.SPRITES;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {

    static BufferedImage image;
    static int size = 256;
    static BufferedImage[] dice = new BufferedImage[7];
    static BufferedImage whiteChecker, blackChecker;
    static BufferedImage endPieceBlack, endPieceWhite;
    static BufferedImage greenColSprite, greenColSpriteFlipped;
    static BufferedImage highlightColSprite, highlightColSpriteFlipped;


    public static void init(){
        try{
            image = ImageIO.read(new File("src/GUI/SPRITES/SpriteBackGammon.png"));
            whiteChecker = grabImage(1,0,1,1);
            blackChecker = grabImage(0,0,1,1);
            for(int i = 0; i < dice.length; i++) {
                dice[i] = grabImage(5,i,1,1);
            }
            endPieceBlack = image.getSubimage(3*size,size/4,size,size/4);
            endPieceWhite = image.getSubimage(3*size,0,size,size/4);

            greenColSprite = grabImage(1,1,1,7);
            greenColSpriteFlipped = grabImage(3,1,1,7);

            highlightColSprite = grabImage(4,1,1,7);
            highlightColSpriteFlipped = grabImage(7,1,1,7);

        }catch(IOException e){
            System.out.println("IO EXCEPTION CATCHED ON THE SPRITE SHEET");
            e.printStackTrace();
        }
    }

    public SpriteSheet() {
    }

    public static BufferedImage grabImage(int col, int row, int height, int width) {
        return image.getSubimage(col*size,row*size,height*size,width*size);
    }

    public static BufferedImage getBlackChecker()
    {
        return blackChecker;
    }

    public static BufferedImage getWhiteChecker()
    {
        return whiteChecker;
    }

    public static BufferedImage getDie(int val)
    {
        return dice[val];
    }

    public static BufferedImage getBlackEnd()
    {
        return endPieceBlack;
    }

    public static BufferedImage getWhiteEnd()
    {
        return endPieceWhite;
    }

    public static BufferedImage getGreenColSprite() {
        return greenColSprite;
    }

    public static BufferedImage getGreenColSpriteFlipped(){
        return greenColSpriteFlipped;
    }

    public static BufferedImage getHighlightColSprite(){
        return highlightColSprite;
    }

    public static BufferedImage getHighlightColSpriteFlipped(){
        return highlightColSpriteFlipped;
    }
}

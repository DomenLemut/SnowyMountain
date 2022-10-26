package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;



public class IO {

    public final static String MAIN_CHAR_SPRITE = "characterFemale.png";
    
    public static BufferedImage loadImage(String dir){
        InputStream is = IO.class.getResourceAsStream("/" + dir);
        BufferedImage img = null;

        try {
            //nalozi slike iz fajla
            img = ImageIO.read(is);
            System.out.println();
            System.out.println("picture: ");
            System.out.println(img + "\n");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
    
}

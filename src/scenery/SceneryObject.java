package scenery;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import util.IO;


public class SceneryObject {

    private BufferedImage img;
    private float x, y;
    private int h, w;

    public SceneryObject(String string, int x, int y, int h, int w) {
        img = IO.loadImage(string);
        this.w = w; this.h = h;
        this.x = x; this.y = y;
    }

    public void render(Graphics g) {
        g.drawImage(img, (int) x, (int) y, h, w, null);
    }
    
}

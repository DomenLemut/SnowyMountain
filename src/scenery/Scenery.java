package scenery;

import java.awt.image.BufferedImage;
import util.IO;
import java.awt.Graphics;

public class Scenery {
    private int tileHeight;
    private int tileWidth;
    private int enlargement = 8;
    private BufferedImage map [][];
    private BufferedImage house;

    public Scenery(int width, int heigth, int tileWidth, int tileHeight){
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.map = new BufferedImage [width][heigth];
        fillMap();
        house = IO.loadImage("House1.png");
    }

    public void setObject(){

    }

    public void fillMap(){
        BufferedImage img = IO.loadImage("Tile.png");
        BufferedImage tile =  img.getSubimage(0, 0, 16, 16);
        System.out.println("tile" + tile);
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = tile;
            }
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                g.drawImage(map[i][j], i * tileHeight * enlargement, j * tileWidth * enlargement, tileHeight * enlargement, tileWidth * enlargement, null);
            }
        }   
        g.drawImage(house, 100, 100, 1024, 1024, null);
    }
}

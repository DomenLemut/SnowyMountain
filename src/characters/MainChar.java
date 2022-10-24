package characters;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;

import javax.imageio.ImageIO;

import static util.Constants.PlayerConstants.*;
import static util.Constants.Directions.*;

public class MainChar extends Character {

    private BufferedImage [][] animations;
    private int aniTick, aniIndex = 0, aniSpeed = 18, moveLength = 3;
    private int playerAction = MOVE_DOWN;
    private int saveDir = DOWN;
    private boolean right, left, up, down;


    public MainChar(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    /*setters for keyboardInputs class
    --------------------------------------*/
    public void setUP(boolean b) {
        this.up = b;
    }

    public void setDOWN(boolean b) {
        this.down = b;
    }

    public void setRIGHT(boolean b) {
        this.right = b;
    }

    public void setLEFT(boolean b) {
        this.left = b;
    }
    //--------------------------------------

    public void update() {
        updatePosition();
        setAnimation();
        updateAnimationTick();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 256, null);
    }


    private void setAnimation() {
        if(left && !right) {
            playerAction = MOVE_LEFT;
            saveDir = LEFT;
        } else if(right && !left) {
            playerAction = MOVE_RIGHT;
            saveDir = RIGHT;
        } else if(!left && !right){
            if(!up && down){
                playerAction = MOVE_DOWN;
                saveDir = DOWN;
            } else if(!down && up){
                playerAction = MOVE_UP;
                saveDir = UP;
            }
            else{
                resetAniTick();
                aniIndex = 1;
            }
        } 
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePosition() {
        if(up && !down)
            if((right && !left)) {
                y -= moveLength / Math.sqrt(2);
                x += moveLength / Math.sqrt(2);
            } else if(left && !right){
                y -= moveLength / Math.sqrt(2);
                x -= moveLength / Math.sqrt(2);
            } else 
                y-= moveLength;
        else if(down && !up) {
            if((right && !left)){
                y += moveLength / Math.sqrt(2);
                x += moveLength / Math.sqrt(2);
            } else if(left && !right){
                y += moveLength / Math.sqrt(2);
                x -= moveLength / Math.sqrt(2);
            } else 
                y += moveLength;
        } else{
            if(left && !right)
                x -= moveLength;
            else if(right && !left)
                x += moveLength;
        }
    }

    private void loadAnimations() {
        InputStream is = getClass().getResourceAsStream("/characterFemale1.png");

        try {
            //nalozi slike iz fajla
            BufferedImage img = ImageIO.read(is);
            System.out.println();
            System.out.println("picture: ");
            System.out.println(img + "\n");



            animations = new BufferedImage [4][4];

            //nalozi za moving
            for(int moves = 0; moves < 4; moves++) {
                for(int subM = 0; subM < 4; subM++) {
                    animations[moves][subM] = img.getSubimage(64 * subM, 64 * moves, 64, 64);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= getAnimationAmount(playerAction))
                aniIndex = 0;
        }
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
    
}

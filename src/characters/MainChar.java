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
    private int aniTick, aniIndex = 0, aniSpeed = 18;
    private int playerAction = IDLE_DOWN;
    private int saveDir = DOWN;
    private boolean right, left, up, down;


    public MainChar(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public int returnAction(){
        return playerAction;
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
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 256, null);
        // g.setColor(Color.BLACK);
        // g.fillRect((int) x, (int) y, 256, 256);
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
        } else 
            switch(saveDir){
                case(LEFT):
                    playerAction = IDLE_LEFT;
                    break;
                case(RIGHT):
                    playerAction = IDLE_RIGHT;
                    break;
                case(DOWN):
                    playerAction = IDLE_DOWN;
                    break;
                case(UP):
                    playerAction = IDLE_UP;
                    break;
            }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePosition() {
        if(up && !down)
            y -= 5;
        else if(down && !up)
            y += 5;
        
        if(left && !right)
            x -= 5;
        else if(right && !left)
            x += 5;
    }

    private void loadAnimations() {
        InputStream is = getClass().getResourceAsStream("/characterFemale.png");

        try {
            //nalozi slike iz fajla
            BufferedImage img = ImageIO.read(is);
            System.out.println();
            System.out.println("picture: ");
            System.out.println(img + "\n");



            animations = new BufferedImage [NUM_MOVES][3];

            // //nalozi za moving
            // for(int moves = 0; moves < 4; moves++) {
            //     for(int subM = 0; subM < getAnimationAmount(moves); subM++) {
            //         animations[moves + 4][subM] = img.getSubimage(64 * subM, 64 * moves, 64, 64);
            //     }
            // }

            // //nalozi za stationary
            // for(int moves = 0; moves < 4; moves++) {
            //     animations[moves][0] = img.getSubimage(64 * 1, 64 * moves, 64, 64);
            // }

            for(int moves = 0; moves < animations.length; moves++){
                for(int i = 0; i < animations[0].length; i++){
                    animations[moves][i] = img.getSubimage(1 * 64, 3 * 64, 64, 64);
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

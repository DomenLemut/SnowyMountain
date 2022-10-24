package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;
import static util.Constants.Directions.*;

public class KeyboardInputs implements KeyListener{

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {

            case KeyEvent.VK_W :
            case KeyEvent.VK_UP:
                gamePanel.getGame().getMainChar().setUP(false);
                break;

            case KeyEvent.VK_S :
            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getMainChar().setDOWN(false);
                break;

            case KeyEvent.VK_A :
            case KeyEvent.VK_LEFT: 
                gamePanel.getGame().getMainChar().setLEFT(false);
                break;
            
            case KeyEvent.VK_D :
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getMainChar().setRIGHT(false);
                break;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W :
            case KeyEvent.VK_UP:
                gamePanel.getGame().getMainChar().setUP(true);
                break;
            case KeyEvent.VK_S :
            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getMainChar().setDOWN(true);
                break;
            case KeyEvent.VK_A :
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getMainChar().setLEFT(true);
                break;
            case KeyEvent.VK_D :
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getMainChar().setRIGHT(true);
                break;
        }
    }
}

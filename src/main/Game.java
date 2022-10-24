package main;

import java.awt.Graphics;

import characters.MainChar;

public class Game implements Runnable{
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;

	private MainChar player;

	public Game() {
		initClasses();

	    gamePanel = new GamePanel(this);
	    gameWindow = new GameWindow(gamePanel);
	    gamePanel.requestFocus();

		startGameLoop();
	}

	private void initClasses() {
		player = new MainChar(000, 000);
	}

	private void startGameLoop() {
	    gameThread = new Thread(this);
	    gameThread.start();
	}

	public void update() {
	//here we update everything, from player to background, everything you can imagine :)
		player.update();
	}

	public void render(Graphics g) {
		//here we render game elements independent to gamePanel
		player.render(g);
	}

	@Override
	public void run() {

	    double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

	    int frames = 0; //FPS
		int updates = 0; //UPS
	    long lastCheck = System.currentTimeMillis();

		double dU = 0; //razlika od updates
		double dF = 0; //razlika od frames

	    while(true) {
			long currentTime = System.nanoTime();

			dU += (currentTime - previousTime) / timePerUpdate;
			dF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if(dU >= 1){
				update();
				updates++;
				dU--;
			}

			if(dF >= 1) {
				gamePanel.repaint();
	            dF--;
	            frames++;
			}

	        if(System.currentTimeMillis() - lastCheck >= 1000) {
				//print staticstics
	            System.out.println("FPS: " + frames + " [" + "ups: " + updates + "] position: " + player.getX() + " " + player.getY() + " animation: " + player.returnAction());
	            frames = 0;
	            lastCheck = System.currentTimeMillis();
				updates = 0;
	    	}
	    }
	}

	public MainChar getMainChar() {
		return this.player;
	}

	
}

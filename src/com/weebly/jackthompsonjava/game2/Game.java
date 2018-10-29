package com.weebly.jackthompsonjava.game2;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import com.weebly.jackthompsonjava.game2.gfx.Assets;
import com.weebly.jackthompsonjava.game2.input.KeyHandler;
import com.weebly.jackthompsonjava.game2.input.MouseHandler;
import com.weebly.jackthompsonjava.game2.overlay.OverlayBuilder;
import com.weebly.jackthompsonjava.game2.states.GameState;
import com.weebly.jackthompsonjava.game2.states.MenuState;
import com.weebly.jackthompsonjava.game2.states.State;

public class Game implements Runnable{

	private int width;
	private int height;
	
	private boolean running; 
	
	private Display display;
	private BufferStrategy bs;
	private Graphics2D g;
	
	private Handler handler;
	private MouseHandler mouseHandler;
	private KeyHandler keyHandler;
	
	private State currentState;
	private GameState gameState;
	private MenuState menuState;
	
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void init() {
		System.out.println("creating display");
		display = new Display(width, height);

		System.out.println("creating handler");
		handler = new Handler(this);
		
		System.out.println("initializing assets");
		Assets.init();
		System.out.println("building overlays");
		OverlayBuilder.init(handler);

		System.out.println("creating key handler");
		keyHandler = new KeyHandler(handler);
		display.getJFrame().addKeyListener(keyHandler);

		System.out.println("creating mouse handler");
		mouseHandler = new MouseHandler(handler);
		display.getJFrame().addMouseListener(mouseHandler);
		display.getJFrame().addMouseMotionListener(mouseHandler);
		display.getCanvas().addMouseListener(mouseHandler);
		display.getCanvas().addMouseMotionListener(mouseHandler);

		System.out.println("creating menu state");
		menuState = new MenuState(handler);
		currentState = menuState;
		
	}
	public void run() {
		System.out.println("INITIALIZING");
		init();
		System.out.println("INITIALIZED");
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		int frames = 0;
		long now;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				ticks ++;
				
				if (delta <= 2) {
					render();
					frames ++;
				}
				
				delta --;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS: " + frames + ", TPS: " + ticks);
				
				timer = 0;
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	private void tick() {
		keyHandler.tick();
		currentState.tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = (Graphics2D) bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		currentState.render(g);
		
		bs.show();
		g.dispose();
	}
	
	public void start() {
		running = true;
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void keyPressed(KeyEvent e) {
		currentState.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		currentState.keyReleased(e);
	}
	
	public void mouseClicked(Point p) {
		currentState.mouseClicked(p);
	}

	public KeyHandler getKeyHandler() {
		return keyHandler;
	}
	
	public MouseHandler getMouseHandler() {
		return mouseHandler;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
		currentState = gameState;
	}
	
}

package com.weebly.jackthompsonjava.game2.states;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.overlay.Overlay;
import com.weebly.jackthompsonjava.game2.overlay.OverlayBuilder;
import com.weebly.jackthompsonjava.game2.world.World;

public class GameState extends State{

	private World world;
	
	private Overlay pauseMenu;
	
	private boolean paused;
	
	public GameState(Handler handler) {
		super(handler);
		
		init();
	}
	
	private void init() {
		System.out.println("creating world");
		world = new World(handler);
		paused = false;
		
		pauseMenu = OverlayBuilder.pauseMenu;
		System.out.println("creating HUD");
	}
	
	public void tick() {		
		if (!paused) {
			world.tick();
		} else {
			pauseMenu.tick();
		}
	}
	
	public void render(Graphics g) {
		world.render(g);
		
		if (paused) {
			pauseMenu.render(g);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			paused = !paused;
		}
		
		world.keyPressed(e);
	}

	 public void keyReleased(KeyEvent e) {
		
	}
	
	public void mouseClicked(Point p) {
		if (paused) {
			pauseMenu.mouseClicked(p);
		}
	}
	
	public void unpause() {
		paused = false;
	}
	
	public boolean paused() {
		return paused;
	}
	
	public World getWorld() {
		return world;
	}
	
}

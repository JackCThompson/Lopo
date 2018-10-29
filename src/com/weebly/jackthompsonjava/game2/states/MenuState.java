package com.weebly.jackthompsonjava.game2.states;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.overlay.Overlay;
import com.weebly.jackthompsonjava.game2.overlay.OverlayBuilder;

public class MenuState extends State{
	
	private Overlay menuOverlay;
	
	public MenuState(Handler handler) {
		super(handler);
	
		menuOverlay = OverlayBuilder.mainMenu;
	}

	public void tick() {
		if (handler.getKeyHandler().space) {
			System.out.println("Loading World");
			handler.getGame().setGameState(new GameState(handler));
		}
		menuOverlay.tick();
	}

	public void render(Graphics g) {
		menuOverlay.render(g);
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
	
	}
	
	public void mouseClicked(Point p) {
		menuOverlay.mouseClicked(p);
	}

}

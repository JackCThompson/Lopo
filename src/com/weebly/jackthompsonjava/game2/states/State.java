package com.weebly.jackthompsonjava.game2.states;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;

public abstract class State {

	protected Handler handler;
	
	protected State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void keyPressed(KeyEvent e);
	
	public abstract void keyReleased(KeyEvent e);
	
	public abstract void mouseClicked(Point p);
}

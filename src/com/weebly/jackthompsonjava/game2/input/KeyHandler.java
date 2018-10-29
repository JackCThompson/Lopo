package com.weebly.jackthompsonjava.game2.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.weebly.jackthompsonjava.game2.Handler;

public class KeyHandler implements KeyListener{
	
	Handler handler;
	
	boolean[] keys;
	
	public boolean W;
	public boolean A;
	public boolean S;
	public boolean D;

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;

	public boolean space;
	public boolean shift;
	
	public KeyHandler(Handler handler) {
		this.handler = handler;
		
		keys = new boolean[500];
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		handler.getGame().keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		handler.getGame().keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {}

	public void tick() {
		W = keys[KeyEvent.VK_W];
		A = keys[KeyEvent.VK_A];
		S = keys[KeyEvent.VK_S];
		D = keys[KeyEvent.VK_D];

		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];

		space = keys[KeyEvent.VK_SPACE];
		shift = keys[KeyEvent.VK_SHIFT];
	}
}

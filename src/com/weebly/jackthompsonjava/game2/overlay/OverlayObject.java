package com.weebly.jackthompsonjava.game2.overlay;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;

public abstract class OverlayObject {

	protected Handler handler;

	protected Rectangle bounds;
	
	protected boolean mouseOver;
	
	public OverlayObject(int x, int y, int width, int height, Handler handler) {
		this.handler = handler;

		mouseOver = false;
		bounds = new Rectangle(x, y, width, height);
	}
	
	protected void tick() {
		updateMouseOver();
	}
	
	private void updateMouseOver() {
		mouseOver = bounds.contains(handler.getMouseHandler().getPoint());
	}

	public abstract void render(Graphics g);

	public abstract void mouseClicked(Point p);
	
	public abstract void keyPressed(KeyEvent e);
}

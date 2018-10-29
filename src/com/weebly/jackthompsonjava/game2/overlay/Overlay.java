package com.weebly.jackthompsonjava.game2.overlay;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Overlay {
	
	protected ArrayList<OverlayObject> items;
	
	public Overlay() {
		
		items = new ArrayList<OverlayObject>();
	}
	
	public void tick() {
		for (OverlayObject o : items) {
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for (OverlayObject o : items) {
			o.render(g);
		}
	}
	
	public void mouseClicked(Point p) {
		System.out.println("mouse clicked");
		for (OverlayObject o : items) {
			o.mouseClicked(p);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		for (OverlayObject o : items) {
			o.keyPressed(e);
		}
	}
	
	public void add(OverlayObject o) {
		items.add(o);
	}	
}

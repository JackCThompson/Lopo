package com.weebly.jackthompsonjava.game2.world;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.EntityHandler;
import com.weebly.jackthompsonjava.game2.gfx.Assets;
import com.weebly.jackthompsonjava.game2.gfx.Camera;

public class World {

	private Handler handler;

	private Zone currentZone;
	private Zone nextZone;
	private boolean saveNextTick;
	
	private Camera camera;
	
	private double scale;
	private int screenPixelWidth;
	private int screenPixelHeight;
	
	public World(Handler handler) {
		this.handler = handler;

		System.out.println("building zone");
		currentZone = ZoneBuilder.buildZone(EntityLoader.getZoneWithPlayer(handler), handler);
		saveNextTick = false;
		System.out.println("creating camera");
		camera = new Camera(currentZone.getEntityHandler().getPlayer(), handler);
		setScale(); 
	}
	
	public void tick() {
		nextZone = currentZone;
		currentZone.tick();
		setScale();
		if (saveNextTick) {
			WorldSaver.saveZone(currentZone, handler);
			WorldSaver.saveZone(nextZone, handler);
			saveNextTick = false;
		}
		currentZone = nextZone;
		camera.tick();
	}
	
	public void render(Graphics g) {
		currentZone.render(g);
	}
	
	private void setScale() {
		double scale1;
		double scale2;
		
		double xScale;
		double yScale;
		
		
		xScale = (double) handler.getGame().getWidth() / currentZone.getMap().getWidth();
		yScale = (double) handler.getGame().getHeight() / currentZone.getMap().getHeight();
		
		scale1 = Math.max(xScale, yScale);
		scale2 = (handler.getGame().getHeight() * 0.2) / (Assets.CELL_LENGTH); 
		scale = Math.max(scale1, scale2);
		
		screenPixelWidth = (int) (handler.getGame().getWidth() / scale);
		screenPixelHeight = (int) (handler.getGame().getHeight() / scale);
	}
	
	public void keyPressed(KeyEvent e) {
		currentZone.keyPressed(e);
	}
	
	public double getScale() {
		return scale;
	}
	
	public int getWidth() {
		return currentZone.getMap().getWidth();
	}
	
	public int getScreenPixelWidth() {
		return screenPixelWidth;
	}
	
	public int getScreenPixelHeight() {
		return screenPixelHeight;
	}
	
	public int getHeight() {
		return currentZone.getMap().getHeight();
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public EntityHandler getEntityHandler() {
		return currentZone.getEntityHandler();
	}
	
	public Zone getCurrentZone() {
		return currentZone;
	}
	
	public void setNextZone(int i) {
		nextZone = ZoneBuilder.buildZone(i, handler);
		saveNextTick = true;
	}
	
	public Zone getNextZone() {
		return nextZone;
	}
}

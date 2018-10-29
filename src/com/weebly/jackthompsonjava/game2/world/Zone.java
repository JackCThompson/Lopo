package com.weebly.jackthompsonjava.game2.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.EntityHandler;
import com.weebly.jackthompsonjava.game2.gfx.MapLoader;

public class Zone {

	private Handler handler;
	
	private EntityHandler entityHandler;
	private BufferedImage map;
	private BufferedImage hitMap;
	
	private int zone;
	
	public Zone(int zone, BufferedImage map, EntityHandler entityHandler, Handler handler) {
		this.handler = handler;

		this.map = map;
		this.entityHandler = entityHandler;
		this.zone = zone;
		map = MapLoader.loadMap(zone);
		hitMap = MapLoader.loadHitMap(zone);
		
		entityHandler = new EntityHandler();
		
	}
	
	public boolean checkCollision(Rectangle newSpace) {
		
		for (int x = 0; x < newSpace.width; x ++) {
			for (int y = 0; y < newSpace.height; y ++) {
				try {
					if (hitMap.getRGB(newSpace.x + x, newSpace.y + y) == Color.BLACK.getRGB()) {
						return true;
					}
				} catch (Exception e) {}
			}
		}
		return false;
	}
	
	public void tick() {
		entityHandler.tick();
	}
	
	public void render(Graphics g) {
		g.drawImage(map, (int) ((0 - handler.getCamera().getXOffset()) * handler.getWorld().getScale()), (int) ((0 - handler.getCamera().getYOffset()) * handler.getWorld().getScale()), (int) (map.getWidth() * handler.getWorld().getScale()), (int) (map.getHeight() * handler.getWorld().getScale()), null);
		entityHandler.render(g);
	}
	
	public void keyPressed(KeyEvent e) {
		entityHandler.keyPressed(e);
	}

	public EntityHandler getEntityHandler() {
		return entityHandler;
	}

	public BufferedImage getMap() {
		return map;
	}

	public int getZone() {
		return zone;
	}
	
}

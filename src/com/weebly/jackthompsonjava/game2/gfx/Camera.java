package com.weebly.jackthompsonjava.game2.gfx;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.Entity;

public class Camera {

	Entity focusedEntity;
	
	private int xOffset;
	private int yOffset;
	
	private Handler handler;
	public Camera(Entity entity, Handler handler) {
		this.handler = handler;
		focusedEntity = entity;
		
		xOffset = 0;
		yOffset = 0;
	}
	
	public void tick() {
		xOffset = ((focusedEntity.getX() + (focusedEntity.getWidth() / 2)) - (handler.getWorld().getScreenPixelWidth() / 2));
		yOffset = ((focusedEntity.getY() + (focusedEntity.getHeight() / 2)) - (handler.getWorld().getScreenPixelHeight() / 2));
		
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset + handler.getWorld().getScreenPixelWidth() > handler.getWorld().getWidth()) {
			xOffset = handler.getWorld().getWidth() - handler.getWorld().getScreenPixelWidth() - 1;
		}
		
		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset + handler.getWorld().getScreenPixelHeight() > handler.getWorld().getHeight()) {
			yOffset = handler.getWorld().getHeight() - handler.getWorld().getScreenPixelHeight() - 1;
		}
	}
	
	public int getXOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}
}

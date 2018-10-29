package com.weebly.jackthompsonjava.game2.gfx;

import java.awt.image.BufferedImage;

import com.weebly.jackthompsonjava.game2.entities.Entity;
import com.weebly.jackthompsonjava.game2.utils.Vals;

public abstract class AnimHandler {

	protected Entity entity;
	
	protected BufferedImage texture;
	
	protected Animation[] still;
	protected Animation[] moving;
	
	protected int direction;
	protected boolean isMoving;
	
	public AnimHandler(Entity entity) {
		this.entity = entity;
		
		still = new Animation[4];
		moving = new Animation[4];
		
		direction = Vals.DOWN;
		isMoving = false;
	}
	
	public void tick() {
		updateDirection();
		isMoving = entity.isMoving();
		
		if (!(this instanceof AnimHandlerUnanimated)) {
			if (isMoving) {
				moving[direction].tick();
			} else {
				still[direction].tick();
			}
		}
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	public BufferedImage getFrame() {
		if (this instanceof AnimHandlerUnanimated) {
			return texture;
		} else if (isMoving) {
			return moving[direction].getAnimationFrame();
		} else {
			return still[direction].getAnimationFrame();
		}
	} 
	
	public void addAnim(boolean isMoving, int direction, Animation anim) {
		if (isMoving) {
			moving[direction] = anim;
		} else {
			still[direction] = anim;
		}
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public abstract void updateDirection();
}

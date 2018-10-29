package com.weebly.jackthompsonjava.game2.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandler;
import com.weebly.jackthompsonjava.game2.utils.Vals;

public abstract class Entity {

	protected Handler handler;

	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	protected Rectangle collisionBox;

	protected String name;
	
	protected AnimHandler animHandler;
	
	protected int ID;
	protected boolean deleteThis;
	
	protected Rectangle bounds;
	
	protected int lastDirection;
	protected int lastDirectionVertical;
	protected int lastDirectionHorizontal;

	protected boolean isMoving;
	protected boolean isMovingVertical;
	protected boolean isMovingHorizontal;
	
	public Entity(int x, int y, Handler handler) {
		this.handler = handler;

		initAnimHandler();
		this.x = x;
		this.y = y;
		
		try {
			this.width = animHandler.getTexture().getWidth();
			this.height = animHandler.getTexture().getHeight();
		} catch(Exception e) {}
			
		lastDirection = Vals.DOWN;
		lastDirectionVertical = Vals.DOWN;
		lastDirectionHorizontal = Vals.RIGHT;
		
		isMoving = false;
		isMovingVertical = false;
		isMovingHorizontal = false;
		
		collisionBox = new Rectangle(0, 0, 0, 0);
		init();
		verify();
	}
	
	protected void tick() {
		animHandler.tick();
	}
	
	protected boolean deleteThis() {
		boolean x = deleteThis;
		deleteThis = false;
		return x;
	}
	
	protected void render(Graphics g) {
		BufferedImage frame = animHandler.getFrame();
		g.drawImage(frame, (int) ((x - handler.getCamera().getXOffset()) * handler.getWorld().getScale()), (int) ((y - handler.getCamera().getYOffset()) * handler.getWorld().getScale()), (int) (frame.getWidth() * handler.getWorld().getScale()), (int) (frame.getHeight() * handler.getWorld().getScale()), null);	
	}
	
	public abstract void sendTo(int zone, int x, int y);
	
	public void verify() {
		boolean verified = true;
		if (ID == 0) {
			System.out.println(name + ": invalid ID");
			verified = false;
		}
		if (collisionBox == null) {
			System.out.println(name + ": missing collisionBox");
			verified = false;
		}
//		if (animated == null) {
//			System.out.println(name + ": missing animated");
//			verified = false;
//		} else if (animated == true & anim == null) {
//			System.out.println(name + ": missing anim");
//			verified = false;
//		} 
		
		
		if (!verified) {
			System.out.println("Please fix the issue(s) and try again.");
			System.exit(0);
		}
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public Rectangle getCollisionBox() {
		return collisionBox;
	}
	
	public Point getFrontPoint() {
		Rectangle hitBox = getCollisionBoxOnMap();
		
		if (lastDirection == Vals.DOWN) {
			return new Point(hitBox.x + hitBox.width / 2, hitBox.y + hitBox.height);
		} else if (lastDirection == Vals.UP) {
			return new Point(hitBox.x + hitBox.width / 2, hitBox.y);
		} else if (lastDirection == Vals.LEFT) {
			return new Point(hitBox.x, hitBox.y + hitBox.height / 2);
		} else if (lastDirection == Vals.RIGHT) {
			return new Point(hitBox.x + hitBox.width, hitBox.y + hitBox.height / 2);
		} else {
			return null;
		}
	}
	
	public Rectangle getCollisionBoxOnMap() {
		return new Rectangle(x + collisionBox.x, y + collisionBox.y, collisionBox.width, collisionBox.height);
	}
	
//	public String getName() {
//		return name;
//	}
	
	public int getID() {
		return ID;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public int[] getDestination() {
		return null;
	}
	
	public int getLastDirection() {
		return lastDirection;
	}
	
	public int getLastDirectionVertical() {
		return lastDirectionVertical;
	}
	
	public int getLastDirectionHorizontal() {
		return lastDirectionHorizontal;
	}
	
	public BufferedImage getTexture() {
		return animHandler.getTexture();
	}
	
	public boolean isMoving() {
		return isMoving;
	}
	
	public boolean isMovingVertical() {
		return isMovingVertical;
	}
	
	public boolean isMovingHorizontal() {
		return isMovingHorizontal;
	}
	
	public void delete() {
		deleteThis = true;
	}
	
	protected abstract void init();
	
	protected abstract void keyPressed(KeyEvent e);
	
	protected abstract void initAnimHandler();
	
}

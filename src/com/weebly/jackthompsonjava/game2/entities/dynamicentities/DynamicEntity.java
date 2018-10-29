package com.weebly.jackthompsonjava.game2.entities.dynamicentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.Entity;
import com.weebly.jackthompsonjava.game2.utils.Vals;

public abstract class DynamicEntity extends Entity {

	protected int xMove;
	protected int yMove;

	public DynamicEntity(int x, int y, Handler handler) {
		super(x, y, handler);
	}
	
	protected void tick() {
		super.tick();
	}
	
	public void sendTo(int zone, int x, int y) {
		this.x = x;
		this.y = y;
		deleteThis = true;
		handler.getWorld().getNextZone().getEntityHandler().add(this);
	}

	public void move() {
		getMovement();
		updateLastMovements();
		correctCollision();
		correctWallCollision();
		updateMoving();
		
		x += xMove;
		y += yMove;

	}
	public void updateLastMovements() {
		if (yMove > 0) {
			lastDirection = Vals.DOWN;
		} else if (yMove < 0) {
			lastDirection = Vals.UP;
		} else if (xMove < 0 ) {
			lastDirection = Vals.LEFT;
		} else if (xMove > 0 ) {
			lastDirection = Vals.RIGHT;
		}
		
		if (yMove > 0) {
			lastDirectionVertical = Vals.DOWN;
		} else if (yMove < 0) {
			lastDirectionVertical = Vals.UP;
		}
		
		if (xMove < 0 ) {
			lastDirectionHorizontal = Vals.LEFT;
		} else if (xMove > 0 ) {
			lastDirectionHorizontal = Vals.RIGHT;
		}
	}
	
	public void updateMoving() {
		if (xMove != 0) {
			isMovingHorizontal = true;
		} else {
			isMovingHorizontal = false;
		}
		
		if (yMove != 0) {
			isMovingVertical= true;
		} else {
			isMovingVertical = false;
		}
		
		if (xMove != 0 | yMove != 0) {
			isMoving = true;
		} else {
			isMoving = false;
		}
		
	}
	
	public void correctCollision() {
		int xInit = xMove;
		int yInit = yMove;
		
		while(true) {
			Rectangle newSpace = new Rectangle(x + collisionBox.x + xMove, y + collisionBox.y + yMove, collisionBox.width, collisionBox.height);
			if (handler.getEntityHandler().checkCollision(this, newSpace) | handler.getCurrentZone().checkCollision(newSpace)) {
				if (xMove > 0) {xMove --;}
				if (xMove < 0) {xMove ++;}
				if (yMove > 0) {yMove --;}
				if (yMove < 0) {yMove ++;}
				
				if (xMove == 0 & yMove == 0) {
					break;
				}
			} else {
				return;
			}
		}
		
		xMove = xInit;
		yMove = 0;
		
		while(true) {
			Rectangle newSpace = new Rectangle(x + collisionBox.x + xMove, y + collisionBox.y, collisionBox.width, collisionBox.height);
			if (handler.getEntityHandler().checkCollision(this, newSpace) | handler.getCurrentZone().checkCollision(newSpace)) {
				if (xMove > 0) {xMove --;}
				if (xMove < 0) {xMove ++;}
				
				if (xMove == 0) {
					break;
				}
			} else {
				return;
			}
		}
		
		xMove = 0;
		yMove = yInit;
		
		while(true) {
			Rectangle newSpace = new Rectangle(x + collisionBox.x, y + collisionBox.y + yMove, collisionBox.width, collisionBox.height);
			if (handler.getEntityHandler().checkCollision(this, newSpace) | handler.getCurrentZone().checkCollision(newSpace)) {
				if (yMove > 0) {yMove --;}
				if (yMove < 0) {yMove ++;}
				
				if (yMove == 0) {
					break;
				}
			} else {
				return;
			}
		}
	}
	
	protected void correctWallCollision() {
		if (!deleteThis) {
			if (x + xMove + collisionBox.x < 0) {
				xMove = 0 - collisionBox.x - x;
			} else if (x + xMove + collisionBox.x + collisionBox.width > handler.getWorld().getWidth()) {
				xMove = handler.getWorld().getWidth() - collisionBox.x - collisionBox.width - x;
			}

			if (y + yMove + collisionBox.y < 0) {
				yMove = 0 - collisionBox.y - y;
			} else if (y + yMove + collisionBox.y + collisionBox.height > handler.getWorld().getHeight()) {
				yMove = handler.getWorld().getHeight() - collisionBox.y - collisionBox.height - y;
			}
		}
	}
	
	protected abstract void getMovement();

}

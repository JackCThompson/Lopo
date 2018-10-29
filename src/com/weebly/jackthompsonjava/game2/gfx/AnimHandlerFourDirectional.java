package com.weebly.jackthompsonjava.game2.gfx;

import com.weebly.jackthompsonjava.game2.entities.Entity;

public class AnimHandlerFourDirectional extends AnimHandler{

	public boolean preferHorizontal;
	
	public AnimHandlerFourDirectional(Entity entity) {
		super(entity);
		
		preferHorizontal = false;
	}
	
	public void updateDirection() {
		if (entity.isMovingHorizontal() && entity.isMovingVertical()) {
			if (preferHorizontal) {
				direction = entity.getLastDirectionHorizontal();
			} else {
				direction = entity.getLastDirectionVertical();
			}
		} else {
			direction = entity.getLastDirection();
		}
	}
	
	public void setPreferHorizontal(Boolean b) {
		preferHorizontal = b;
	}

}

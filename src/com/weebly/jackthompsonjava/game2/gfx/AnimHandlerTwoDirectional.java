package com.weebly.jackthompsonjava.game2.gfx;

import com.weebly.jackthompsonjava.game2.entities.Entity;

public class AnimHandlerTwoDirectional extends AnimHandler{

	public AnimHandlerTwoDirectional(Entity entity) {
		super(entity);
	}
	
	public void updateDirection() {
		direction = entity.getLastDirectionVertical();
	}

}

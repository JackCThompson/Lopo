package com.weebly.jackthompsonjava.game2.gfx;

import com.weebly.jackthompsonjava.game2.entities.Entity;
import com.weebly.jackthompsonjava.game2.utils.Vals;

public class AnimHandlerOneDirectional extends AnimHandler{

	public AnimHandlerOneDirectional(Entity entity) {
		super(entity);
	}
	
	public void updateDirection() {
		direction = Vals.DOWN;
	}

}

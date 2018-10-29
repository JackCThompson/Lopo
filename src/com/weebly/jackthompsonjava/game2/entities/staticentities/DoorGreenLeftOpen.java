package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class DoorGreenLeftOpen extends StaticEntity{

	public DoorGreenLeftOpen(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 16;
		this.height = 34;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 33, 16, 1); 
	}

	@Override
	protected void init() {
		ID = 2120;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.doorGreenLeftOpen);
	}

}

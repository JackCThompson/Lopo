package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class DoorGreyLeft extends StaticEntity{

	public DoorGreyLeft(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 18;
		this.height = 34;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 0, 0, 0); 
	}

	@Override
	protected void init() {
		ID = 2130;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.doorGreyLeft);
	}

}

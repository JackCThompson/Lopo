package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class Locker extends StaticEntity{

	public Locker(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 49;
		this.height = 43;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 36, 49, 7); 
	}

	@Override
	protected void init() {
		ID = 2002;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.locker);
	}

}

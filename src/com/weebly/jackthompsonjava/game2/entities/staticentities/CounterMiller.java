package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class CounterMiller extends StaticEntity{

	public CounterMiller(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 67;
		this.height = 30;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 20, 67, 10); 
	}

	@Override
	protected void init() {
		ID = 2005;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.counterMiller);
	}

}

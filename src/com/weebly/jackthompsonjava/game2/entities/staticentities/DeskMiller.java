package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class DeskMiller extends StaticEntity{

	public DeskMiller(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 77;
		this.height = 32;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 19, 77, 13); 
	}

	@Override
	protected void init() {
		ID = 2004;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.deskMiller);
	}

}

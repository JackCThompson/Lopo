package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class DeskEngbersTall extends StaticEntity{

	public DeskEngbersTall(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 15;
		this.height = 61;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 15, 15, 46); 
	}

	@Override
	protected void init() {
		ID = 2007;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.deskEngbersTall);
	}

}

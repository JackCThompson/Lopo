package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class DeskBrian extends StaticEntity{

	public DeskBrian(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 11;
		this.height = 30;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 11, 11, 19); 
	}

	@Override
	protected void init() {
		ID = 2001;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.deskBrian);
	}

}

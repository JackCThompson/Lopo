package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class VendingMachine extends StaticEntity{

	public VendingMachine(int x, int y, Handler handler) {
		super(x, y, handler);
		
		this.width = 22;
		this.height = 38;

		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 32, 22, 6); 
	}

	@Override
	protected void init() {
		ID = 2008;
	}

	@Override
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		animHandler.setTexture(Assets.vendingMachine);
	}

}

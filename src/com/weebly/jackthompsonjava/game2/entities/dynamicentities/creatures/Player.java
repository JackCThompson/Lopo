package com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures;

import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.controllers.PlayerController;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;
import com.weebly.jackthompsonjava.game2.gfx.Assets;

public class Player extends Creature{
	
	private long lastSendTo;
	
	public Player(int x, int y, Handler handler) {
		super(x, y, handler);
		lastSendTo = 0;
	}
	
	protected void init() {
		this.controller = new PlayerController(this, handler);
		this.collisionBox = new Rectangle(11, 22, 10, 10);
		this.name = "player";
		this.ID = 1000;
		
		speed = 1;
	}
	
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
		
		animHandler.setTexture(Assets.jack);
	}
	
	@Override
	public void tick() {
		super.tick();
//-+		System.out.println(x + " " + y);
		
	}
	
	public void sendTo(int zone, int x, int y) {
		System.out.println(x + " " + y);
		if ((System.currentTimeMillis() - lastSendTo) > 1000) {
			lastSendTo = System.currentTimeMillis();
			handler.getWorld().setNextZone(zone);
			super.sendTo(zone, x, y);
		}
	}
}

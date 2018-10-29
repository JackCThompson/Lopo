package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.Entity;
import com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures.Player;
import com.weebly.jackthompsonjava.game2.gfx.AnimHandlerUnanimated;

public class Portal extends StaticEntity{
	
	private int telZone;
	private int telY;
	private int telX;
	
	public Portal(int x, int y, int width, int height, int telZone, int telX, int telY, Handler handler) {
		super(x, y, handler);
		
		System.out.println(x + " " + y + " " + width + " " + height);
		this.width = width;
		this.height = height;
		this.telZone = telZone;
		this.telX = telX;
		this.telY = telY;
		bounds = new Rectangle(x, y, width, height);      
		collisionBox = new Rectangle(0, 0, 0, 0);         
	}
	
	protected void initAnimHandler() {
		animHandler = new AnimHandlerUnanimated(this);
	}

	protected void init() {  
//		bounds = new Rectangle(x, y, width, height);      
//		collisionBox = new Rectangle(0, 0, 0, 0);    
		name = "portal";
		ID = 1;
	}
	
	public void tick() {
		super.tick();
		
		Entity e = handler.getEntityHandler().getCollidingEntity(this, bounds);
		if (e instanceof Player && !handler.getKeyHandler().shift) { 
			e.sendTo(telZone, telX, telY);
		}
	}
	
	@Override
	public void render(Graphics g) {
		
	}
	
	public int[] getDestination() {
		return new int[] {telZone, telX, telY};
	}
	
	public void teleport(Entity e) {
		System.out.println("teleporting");
		e.sendTo(telZone, telX, telY);
	}

}

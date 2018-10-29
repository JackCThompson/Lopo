package com.weebly.jackthompsonjava.game2.entities.staticentities;

import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(int x, int y, Handler handler) {
		super(x, y, handler);
	}
	
	protected void tick() {
		super.tick();
	}
	
	public void sendTo(int zone, int x, int y) {
		
	}
	
	public void sendTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void keyPressed(KeyEvent e) {
		
	}
}

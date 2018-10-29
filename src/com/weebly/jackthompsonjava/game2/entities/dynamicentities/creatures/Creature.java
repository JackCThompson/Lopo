package com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures;

import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.controllers.Controller;
import com.weebly.jackthompsonjava.game2.entities.dynamicentities.DynamicEntity;

public abstract class Creature extends DynamicEntity{
	
	protected Controller controller;
	
	protected int speed;
	
	public Creature(int x, int y, Handler handler) {
		super(x, y, handler);
	}
	
	protected void tick() {
		super.tick();
		
		controller.tick();
	}
	
	public void getMovement() {
		xMove = controller.getXMove();
		yMove = controller.getYMove();
	}
	
	protected void keyPressed(KeyEvent e) {
		controller.keyPressed(e);
	}
	
	public int getSpeed() {
		return speed;
	}
	
}

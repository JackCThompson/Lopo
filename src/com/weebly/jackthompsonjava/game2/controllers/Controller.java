package com.weebly.jackthompsonjava.game2.controllers;

import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures.Creature;

public abstract class Controller {
	
	protected Creature creature;
	protected Handler handler;
	
	protected int xMove;
	protected int yMove;
	
	public Controller(Creature creature, Handler handler) {
		this.creature = creature;
		this.handler = handler;
	}
	
	public void tick() {
			setMovement();
			creature.move();
	}
	
	public int getXMove() {
		return xMove;
	}
	
	public int getYMove() {
		return yMove;
	}
	
	protected void movement_followPlayer() {
		int x = handler.getEntityHandler().getPlayer().getX();
		int y = handler.getEntityHandler().getPlayer().getY();
		int xDistance = x - creature.getX();
		int yDistance = y - creature.getY();
		
		if (Math.abs(xDistance) < creature.getSpeed()) {
			xMove = xDistance;
		} else if (creature.getX() < x) {
			xMove = creature.getSpeed();
		} else if (creature.getX() > x){
			xMove = -creature.getSpeed();
		} else {
			xMove = 0;
		}
		
		if (Math.abs(yDistance) < creature.getSpeed()) {
			yMove = yDistance;
		} else if (creature.getY()  < y ) {
			yMove = creature.getSpeed();
		} else if (creature.getY() > y){
			yMove = -creature.getSpeed();
		} else {
			yMove = 0;
		}
	}
	
	protected abstract void setMovement();
	
	public abstract void keyPressed(KeyEvent e);
}

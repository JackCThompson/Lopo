package com.weebly.jackthompsonjava.game2.controllers;

import java.awt.event.KeyEvent;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures.Creature;
import com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures.Player;

public class PlayerController extends Controller{

	public PlayerController(Player player, Handler handler) {
		super((Creature) player, handler);
	}

	public void setMovement() {
		xMove = 0;
		yMove = 0;
		int speed = creature.getSpeed();
		
		if (handler.getKeyHandler().W | handler.getKeyHandler().up) {
			yMove -= speed;
		}
		if (handler.getKeyHandler().S | handler.getKeyHandler().down) {
			yMove += speed;
		}
		if (handler.getKeyHandler().A | handler.getKeyHandler().left) {
			xMove -= speed;
		}
		if (handler.getKeyHandler().D | handler.getKeyHandler().right) {
			xMove += speed;
		}
	}
	
	public void attack() {
		
	}
	
	public void keyPressed(KeyEvent e) {
	}

}

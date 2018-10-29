package com.weebly.jackthompsonjava.game2;

import com.weebly.jackthompsonjava.game2.entities.EntityHandler;
import com.weebly.jackthompsonjava.game2.gfx.Camera;
import com.weebly.jackthompsonjava.game2.input.KeyHandler;
import com.weebly.jackthompsonjava.game2.input.MouseHandler;
import com.weebly.jackthompsonjava.game2.states.GameState;
import com.weebly.jackthompsonjava.game2.world.World;
import com.weebly.jackthompsonjava.game2.world.Zone;

public class Handler {

	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public KeyHandler getKeyHandler() {
		return game.getKeyHandler();
	}
	
	public GameState getGameState() {
		return game.getGameState();
	}
	
	public MouseHandler getMouseHandler() {
		return game.getMouseHandler();
	}
	
	public World getWorld() {
		return game.getGameState().getWorld();
	}
	
	public Camera getCamera() {
		return game.getGameState().getWorld().getCamera();
	}
	
	public EntityHandler getEntityHandler() {
		return game.getGameState()
				.getWorld()
				.getEntityHandler();
	}
	
	public Zone getCurrentZone() {
		return game.getGameState().getWorld().getCurrentZone();
	}
}

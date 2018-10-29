package com.weebly.jackthompsonjava.game2.overlay;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.overlay.menu.Button;
import com.weebly.jackthompsonjava.game2.states.GameState;
import com.weebly.jackthompsonjava.game2.world.WorldSaver;

public class OverlayBuilder {

	public static Overlay mainMenu;
	public static Overlay pauseMenu;
	
	private static int margin;
	private static int buttonHeight;
	private static int buttonWidth;
	
	public static void init(Handler handler) {
		buttonHeight = (int) (handler.getGame().getHeight() * 0.1);
		buttonWidth = (int) (handler.getGame().getWidth() * 0.9);
		margin = (int) (handler.getGame().getWidth() * 0.05);
		
		mainMenu = new Overlay();
		mainMenu.add(new Button(margin, margin, buttonWidth, buttonHeight, "Play", handler) {
			public void onClick() {
				System.out.println("Play");
				handler.getGame().setGameState(new GameState(handler));
			}
		});
		
		pauseMenu = new Overlay();
		pauseMenu.add(new Button(margin, margin, buttonWidth, buttonHeight, "Continue", handler) {
			public void onClick() {
				handler.getGame().getGameState().unpause();
			}
		});
		pauseMenu.add(new Button(margin, (2 * margin) + buttonHeight, buttonWidth, buttonHeight, "Save", handler) {
			public void onClick() {
				WorldSaver.saveZone(handler.getCurrentZone(), handler);
			}
		});
	}
}

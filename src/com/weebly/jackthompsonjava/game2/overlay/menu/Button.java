package com.weebly.jackthompsonjava.game2.overlay.menu;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.overlay.OverlayObject;

public abstract class Button extends OverlayObject{

	
	private BufferedImage[] textures;
	
	public Button(int x, int y, int width, int height, String text, Handler handler) {
		super(x, y, width, height, handler);
		textures = ButtonTextureBuilder.getButtonTextures(text, bounds.width, bounds.height);
	}
	
	public void tick() {
		super.tick();
	}
	
	public void render(Graphics g) {
		if (mouseOver) {
			g.drawImage(textures[1], bounds.x, bounds.y, null);
		} else {
			g.drawImage(textures[0], bounds.x, bounds.y, null);
		}
	}
	
	public void mouseClicked(Point p) {
		if (bounds.contains(p)) {
			onClick();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
	
	public abstract void onClick();
}

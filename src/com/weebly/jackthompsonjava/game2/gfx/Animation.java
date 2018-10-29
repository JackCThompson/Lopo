package com.weebly.jackthompsonjava.game2.gfx;

import java.awt.image.BufferedImage;

public class Animation {

	private BufferedImage[] frames;
	
	private long lastTime;
	private long speed;
	private int frameNumber;
	
	public Animation(long speed, BufferedImage[] frames) {
		this.frames = frames;
		this.speed = speed;
		lastTime = System.currentTimeMillis();
		frameNumber = 0;
	}
	
	public void tick() {
		if (System.currentTimeMillis() - lastTime >= speed) {
			lastTime = System.currentTimeMillis();
			
			frameNumber ++;
			if (frameNumber >= frames.length) {
				frameNumber = 0;
			}
		}
	}
	
	public BufferedImage getAnimationFrame() {
		return frames[frameNumber];
	}
}

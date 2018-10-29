package com.weebly.jackthompsonjava.game2.gfx;

import java.awt.image.BufferedImage;
import java.io.File;

public class MapLoader {

	public static BufferedImage loadMap(int zone) {

		try {
			return ImageLoader.loadImage(new File("res/gfx/world/map" + zone + ".png"));
		} catch (Exception e) {
			System.out.println("No map found for Zone " + zone);
			e.printStackTrace();
			return null;
		}
	}

	public static BufferedImage loadHitMap(int zone) {

		try {
			return ImageLoader.loadImage(new File("res/gfx/world/hitmap" + zone + ".png"));
		} catch (Exception e) {
			System.out.println("No hit map found for Zone " + zone);
			e.printStackTrace();
			return null;
		}
	}
}

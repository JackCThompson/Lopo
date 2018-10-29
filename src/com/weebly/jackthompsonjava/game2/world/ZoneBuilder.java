package com.weebly.jackthompsonjava.game2.world;

import java.awt.image.BufferedImage;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.EntityHandler;
import com.weebly.jackthompsonjava.game2.gfx.MapLoader;

public class ZoneBuilder {
	
	public static Zone buildZone(int zone, Handler handler) {
		System.out.println("loading entity handler");
		EntityHandler entityHandler = EntityLoader.loadEntityHandler(zone, handler);
		System.out.println("loading map");
		BufferedImage map = MapLoader.loadMap(zone);
			
		return new Zone(zone , map, entityHandler, handler);
	}
}

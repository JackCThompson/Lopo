package com.weebly.jackthompsonjava.game2.world;

import java.awt.Graphics;
import java.util.ArrayList;

import com.weebly.jackthompsonjava.game2.entities.EntityHandler;

public class ZoneHandler {

	public ArrayList<Zone> zoneList;
	
	public ZoneHandler() {
		zoneList = new ArrayList<Zone>();
	}
	
	public void tick() {
		for (Zone z : zoneList) {
			z.tick();
		}
	}
	
	public void Render(Graphics g) {
		for (Zone z : zoneList) {
			z.render(g);
		}
	}
	
	public void add(Zone z) {
		zoneList.add(z);
	}
	
	public Zone get(int i) {
		return zoneList.get(i);
	}
	
	public int getSize() {
		return zoneList.size();
	}
	
	public EntityHandler[] getEntityHandlers() {
		EntityHandler[] entityHandlers = new EntityHandler[zoneList.size()];
		
		for (int i = 0; i < zoneList.size(); i ++) {
			entityHandlers[i] = zoneList.get(i).getEntityHandler();
		}
		
		return entityHandlers;
	}
	
	public Zone getZoneWithPlayer() {
		for (Zone z : zoneList) {
			if(z.getEntityHandler().getPlayer() != null) {
				return z;
			}
		}
		System.out.println("Failed to find player: returning null");
		return null;
	}
}

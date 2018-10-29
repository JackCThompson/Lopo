package com.weebly.jackthompsonjava.game2.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;

import com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures.Player;

public class EntityHandler {

	private Player player;
	
	private ArrayList<Entity> entityList;
	private ArrayList<Entity> entitiesToAdd;
	Comparator<Entity> renderSorter = new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			int aBase;
			int bBase;
			
			if (a.getCollisionBox().height == 0) {
				aBase = a.getY() + a.getHeight();
			} else {
				 aBase = a.getY() + a.getCollisionBox().y + a.getCollisionBox().height;
			}
			if (b.getCollisionBox().height == 0) {
				bBase = b.getY() + b.getHeight();
			} else {
				 bBase = b.getY() + b.getCollisionBox().y + b.getCollisionBox().height;
			}
			
			if (aBase < bBase) {
				return -1;
			}
			return 1;
		}
	};
	
	public EntityHandler() {
		entityList = new ArrayList<Entity>();
		entitiesToAdd = new ArrayList<Entity>();
	}
	
	public void tick() {
		for (Entity e : entityList) {
			e.tick();
		}
		removeAll();
		addAll();
		entityList.sort(renderSorter);
	}
	
	public void render(Graphics g) {
		for (Entity e : entityList) {
			e.render(g);
		}
	}
	
	public boolean checkCollision(Entity entity, Rectangle space) {
		for (int i = 0; i < entityList.size(); i ++) {
			Entity e = entityList.get(i);
			
			if (e.equals(entity)) {
				continue;
			} else if (e.getCollisionBoxOnMap().intersects(space)) {
				return true;
			}
		}
		return false;
	}
	
	public Entity getCollidingEntity(Entity entity, Rectangle space) {
		for (Entity e : entityList) {
			if (e.equals(entity)) {
				continue;
			} else if (e.getCollisionBoxOnMap().intersects(space)) {
				return e;
			}
		}
		return null;
	} 

	public void keyPressed(KeyEvent a) {
		for (Entity e : entityList) {
			e.keyPressed(a);
		}
	}
	
	//Adders and Removers
	
	public void add(Entity e) {
		entitiesToAdd.add(e);
		System.out.println("adding");
		
		if (e instanceof Player && player == null) {
			player = (Player) e;
		}
	}
	
	public void addAll() {
		for(Entity e : entitiesToAdd) {
			entityList.add(e);
		}
		entitiesToAdd.clear();
	}
	
	public void remove(Entity e) {
		entityList.remove(e);
	}
	
	public void removeAll() {
		for (int i = entityList.size() - 1 ; i >= 0; i --) {
			Entity e = entityList.get(i);
				if(e.deleteThis()) {
					if (e instanceof Player) {
						player = null;
					}
					entityList.remove(e);
				}
		}
	}
	
	//Getters and Setters
	
	public Player getPlayer() {
		return player;
	}
	
	public ArrayList<Entity> getEntityList() {
		return entityList;
	}
	
}

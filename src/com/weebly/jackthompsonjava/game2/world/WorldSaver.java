package com.weebly.jackthompsonjava.game2.world;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.Entity;
import com.weebly.jackthompsonjava.game2.entities.EntityHandler;

public class WorldSaver {

	public static void saveZone(Zone zone, Handler handler) {
		EntityHandler entityHandler = zone.getEntityHandler();
		String entityData = zone.getZone() + " ";
		String inventoryData = "";
		
		if (entityHandler.getPlayer() != null) {
			entityData += "1";
		} else {
			entityData += "0";
		}
		
		entityData += "\n";

		for (Entity e : entityHandler.getEntityList()) {
			entityData += makeEntityLine(e);
			entityData += "\n";
		}

		File entityDataFile = new File("res\\world\\zone" + zone.getZone() + ".txt");
		if (entityDataFile.exists()) {
			entityDataFile.delete();
		}
		try {
			entityDataFile.getParentFile().mkdirs();
			entityDataFile.createNewFile();
		} catch (Exception e ) {
			e.printStackTrace();
		}

		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new BufferedWriter(new FileWriter(entityDataFile, false)), true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		printWriter.print(entityData);
		printWriter.print(inventoryData);
		printWriter.flush();

		System.out.println("Saved Zone " + zone.getZone());
	}
	
	private static String makeEntityLine(Entity e) {
		String line = "";
		
		line += e.getID() + " ";
		line += e.getX() + " ";
		line += e.getY() + " ";

		if (e.getID() == 1) {
			line += e.getBounds().width + " ";
			line += e.getBounds().height + " ";
			line += e.getDestination()[0] + " ";
			line += e.getDestination()[1] + " ";
			line += e.getDestination()[2] + " ";
		}
		
		return line;
	}
	
}
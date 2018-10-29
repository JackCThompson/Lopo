package com.weebly.jackthompsonjava.game2.world;

import java.io.File;

import com.weebly.jackthompsonjava.game2.Handler;
import com.weebly.jackthompsonjava.game2.entities.Entity;
import com.weebly.jackthompsonjava.game2.entities.EntityHandler;
import com.weebly.jackthompsonjava.game2.entities.dynamicentities.creatures.Player;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Bratz;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Brian;
import com.weebly.jackthompsonjava.game2.entities.staticentities.CounterMiller;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DJ;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DeskBrian;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DeskEngbersLong;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DeskEngbersTall;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DeskManch;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DeskMiller;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBlackDouble;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBlackLeft;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBlackRight;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBrownDouble;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBrownLeft;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBrownLeftOpen;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBrownRight;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorBrownRightOpen;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorGreenLeftOpen;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorGreyDouble;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorGreyLeft;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorGreyLeftOpen;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorGreyRight;
import com.weebly.jackthompsonjava.game2.entities.staticentities.DoorGreyRightOpen;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Elevator;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Engbers;
import com.weebly.jackthompsonjava.game2.entities.staticentities.FilingCabinet;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Friezen;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Locker;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Manchester;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Miller;
import com.weebly.jackthompsonjava.game2.entities.staticentities.Portal;
import com.weebly.jackthompsonjava.game2.entities.staticentities.VendingMachine;
import com.weebly.jackthompsonjava.game2.utils.Utils;

public class EntityLoader {

	public static int getZoneWithPlayer(Handler handler) {
		for (int i = 0; ; i ++) {
			String fileText = "";
			String path = "res/world/zone" + i + ".txt";
			File file = new File(path);

			if (file.exists()) {
				try {
					fileText = Utils.loadFileAsString(path);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			} else {
				break;
			}

			String[] value = fileText.split("\\s+");
			if (Utils.parseInt(value[1]) == 1) {
				return i;
			}
		}

		System.out.println("Could not find zone with player");
		System.exit(0);
		return 0;
	}
	
	public static EntityHandler loadEntityHandler(int zone, Handler handler) {
		String fileText = "";
		String path = "res/world/zone" + zone + ".txt";
		File file = new File(path);

		if (file.exists()) {
			try {
				fileText = Utils.loadFileAsString(path);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		} else {
			System.out.println("Error loading file " + file.toString());
			System.exit(0);
		}
		String[] entities = fileText.split("\n");
		
		EntityHandler entityHandler = new EntityHandler();

		for  (int i = 1; i < entities.length; i ++) {
			Entity e = null;
			String[] column = entities[i].split("\\s+");

			if (column[0].equals("1")) {
				e = new Portal(Utils.parseInt(column[1]), Utils.parseInt(column[2]), Utils.parseInt(column[3]), Utils.parseInt(column[4]), Utils.parseInt(column[5]), Utils.parseInt(column[6]), Utils.parseInt(column[7]), handler);
			} else if (column[0].equals("1000")) {
				e = new Player(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			} else if (column[0].equals("1001")) {
				e = new Brian(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			} else if (column[0].equals("1002")) {
				e = new DJ(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			} else if (column[0].equals("1003")) {
				e = new Engbers(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			} else if (column[0].equals("1004")) {
				e = new Friezen(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			} else if (column[0].equals("1005")) {
				e = new Manchester(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			} else if (column[0].equals("1006")) {
				e = new Miller(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			} else if (column[0].equals("1007")) {
				e = new Bratz(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}
			
			else if (column[0].equals("2000")) {
				e = new DeskManch(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2001")) {
				e = new DeskBrian(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2002")) {
				e = new Locker(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2003")) {
				e = new FilingCabinet(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2004")) {
				e = new DeskMiller(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2005")) {
				e = new CounterMiller(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2006")) {
				e = new DeskEngbersLong(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2007")) {
				e = new DeskEngbersTall(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2008")) {
				e = new VendingMachine(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}
			
			else if (column[0].equals("2100")) {
				e = new DoorBrownLeft(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2101")) {
				e = new DoorBrownRight(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2102")) {
				e = new DoorBrownDouble(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2103")) {
				e = new DoorBrownLeftOpen(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2104")) {
				e = new DoorBrownRightOpen(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}
			
			else if (column[0].equals("2110")) {
				e = new DoorBlackLeft(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2111")) {
				e = new DoorBlackRight(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2112")) {
				e = new DoorBlackDouble(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}
			
			else if (column[0].equals("2120")) {
				e = new DoorGreenLeftOpen(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}
			
			else if (column[0].equals("2130")) {
				e = new DoorGreyLeft(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2131")) {
				e = new DoorGreyRight(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2132")) {
				e = new DoorGreyDouble(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2133")) {
				e = new DoorGreyLeftOpen(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}else if (column[0].equals("2134")) {
				e = new DoorGreyRightOpen(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}
			
			else if (column[0].equals("2140")) {
				e = new Elevator(Utils.parseInt(column[1]), Utils.parseInt(column[2]), handler);
			}
			
			if (e != null) {
				entityHandler.add(e);
			}

		}
		
		entityHandler.addAll();

		System.out.println("Loaded zone " + zone);
		return entityHandler;
	}	 
	
} 

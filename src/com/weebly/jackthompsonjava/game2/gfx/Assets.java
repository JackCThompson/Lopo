package com.weebly.jackthompsonjava.game2.gfx;

import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {

	public static final int CELL_LENGTH = 32;
	public static final int ITEM_CELL_LENGTH = 32;

	public static TextureSheet characterSheet;
	public static TextureSheet lockerSheet;
	
	public static BufferedImage peterson;
	public static BufferedImage manchester;
	public static BufferedImage miller;
	public static BufferedImage bratz;
	public static BufferedImage friezen;
	public static BufferedImage dj;
	public static BufferedImage engbers;
	public static BufferedImage jack;

	public static BufferedImage locker;
	public static BufferedImage filingCabinet;
	public static BufferedImage vendingMachine;

	public static BufferedImage deskManch;
	public static BufferedImage deskBrian;
	public static BufferedImage deskEngbersLong;
	public static BufferedImage deskEngbersTall;
	public static BufferedImage deskMiller;
	public static BufferedImage counterMiller;

	public static BufferedImage elevator;

	public static BufferedImage doorBrownLeft;
	public static BufferedImage doorBrownRight;
	public static BufferedImage doorBrownLeftOpen;
	public static BufferedImage doorBrownRightOpen;
	public static BufferedImage doorBrownDouble;

	public static BufferedImage doorGreyLeft;
	public static BufferedImage doorGreyRight;
	public static BufferedImage doorGreyLeftOpen;
	public static BufferedImage doorGreyRightOpen;
	public static BufferedImage doorGreyDouble;

	public static BufferedImage doorGreenLeftOpen;

	public static BufferedImage doorBlackLeft;
	public static BufferedImage doorBlackRight;
	public static BufferedImage doorBlackDouble;
	
	public static void init() {
		locker = ImageLoader.loadImage(new File("res/gfx/textures/Locker.png"));
		filingCabinet = ImageLoader.loadImage(new File("res/gfx/textures/FilingCabinet.png"));
		vendingMachine = ImageLoader.loadImage(new File("res/gfx/textures/VendingMachine.png"));

		deskManch = ImageLoader.loadImage(new File("res/gfx/textures/DeskManch.png"));
		deskBrian = ImageLoader.loadImage(new File("res/gfx/textures/DeskBrian.png"));
		deskEngbersLong = ImageLoader.loadImage(new File("res/gfx/textures/DeskEngbersLong.png"));
		deskEngbersTall = ImageLoader.loadImage(new File("res/gfx/textures/DeskEngbersTall.png"));
		deskMiller = ImageLoader.loadImage(new File("res/gfx/textures/DeskMiller.png"));
		counterMiller = ImageLoader.loadImage(new File("res/gfx/textures/CounterMiller.png"));
		
		elevator = ImageLoader.loadImage(new File("res/gfx/textures/Elevator.png"));

		doorBrownLeft = ImageLoader.loadImage(new File("res/gfx/textures/DoorBrownLeft.png"));
		doorBrownRight = ImageLoader.loadImage(new File("res/gfx/textures/DoorBrownRight.png"));
		doorBrownLeftOpen = ImageLoader.loadImage(new File("res/gfx/textures/DoorBrownLeftOpen.png"));
		doorBrownRightOpen = ImageLoader.loadImage(new File("res/gfx/textures/DoorBrownRightOpen.png"));
		doorBrownDouble = ImageLoader.loadImage(new File("res/gfx/textures/DoorBrownDouble.png"));
		
		doorGreyLeft = ImageLoader.loadImage(new File("res/gfx/textures/DoorGreyLeft.png"));
		doorGreyRight = ImageLoader.loadImage(new File("res/gfx/textures/DoorGreyRight.png"));
		doorGreyLeftOpen = ImageLoader.loadImage(new File("res/gfx/textures/DoorGreyLeftOpen.png"));
		doorGreyRightOpen = ImageLoader.loadImage(new File("res/gfx/textures/DoorGreyRightOpen.png"));
		doorGreyDouble = ImageLoader.loadImage(new File("res/gfx/textures/DoorGreyDouble.png"));
		
		doorGreenLeftOpen = ImageLoader.loadImage(new File("res/gfx/textures/DoorGreenLeftOpen.png"));
		
		doorBlackLeft = ImageLoader.loadImage(new File("res/gfx/textures/DoorBlackLeft.png"));
		doorBlackRight = ImageLoader.loadImage(new File("res/gfx/textures/DoorBlackRight.png"));
		doorBlackDouble= ImageLoader.loadImage(new File("res/gfx/textures/DoorBlackDouble.png"));
		
		characterSheet = new TextureSheet(ImageLoader.loadImage(new File("res/gfx/textures/CharacterSheet.png")));

		peterson = crop(0, 0, 1, 1, characterSheet);
		manchester = crop(1, 0, 1, 1, characterSheet);
		dj = crop(0, 1, 1, 1, characterSheet);
		engbers = crop(0, 2, 1, 1, characterSheet);
		friezen = crop(0, 3, 1, 1, characterSheet);
		miller = crop(1, 1, 1, 1, characterSheet);
		bratz = crop(1, 2, 1, 1, characterSheet);
		jack = crop(2, 0, 1, 1, characterSheet);	
	}
	
	private static BufferedImage crop(int x, int y, int width, int height, TextureSheet sheet) {
		return sheet.crop(x * CELL_LENGTH, y * CELL_LENGTH, width * CELL_LENGTH, height * CELL_LENGTH);
	}
	
//	private static BufferedImage cropItem(int x, int y, int width, int height, TextureSheet sheet) {
//		return sheet.crop(x * ITEM_CELL_LENGTH, y * ITEM_CELL_LENGTH, width * ITEM_CELL_LENGTH, height * ITEM_CELL_LENGTH);
//	}
	
//	private static BufferedImage[] mirror(BufferedImage[] image) {
//		BufferedImage[] image2 = new BufferedImage[image.length];
//		
//		for (int i = 0; i < image2.length; i ++) {
//			image2[i] = mirror(image[i]);
//		}
//		
//		return image2;
//	}
	
//	private static BufferedImage mirror(BufferedImage image) {
//		BufferedImage image2 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
//		image2.getGraphics().drawImage(image, image2.getWidth(), 0, -image2.getWidth(), image2.getHeight(), null);
//	
//		return image2;
//	}
}

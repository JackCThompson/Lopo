package com.weebly.jackthompsonjava.game2.overlay.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class ButtonTextureBuilder {

	public static BufferedImage[] getButtonTextures(String string, int width, int height) {
		BufferedImage[] textures = new BufferedImage[2];
		textures[0] = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		textures[1] = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics g0 = textures[0].getGraphics();
		Graphics g1 = textures[1].getGraphics();
		
		g0.setColor(new Color(155, 155, 155));
		g1.setColor(new Color(120, 120, 120));
		
		g0.fillRect(0, 0, textures[0].getWidth(), textures[0].getHeight());
		g1.fillRect(0, 0, textures[1].getWidth(), textures[1].getHeight());
		
		Font font = new Font("Courier", Font.PLAIN, (int) (textures[0].getHeight() * 0.8));
		
		g0.setFont(font);
		g1.setFont(font);

		Rectangle2D rect = g0.getFontMetrics().getStringBounds(string, textures[0].getGraphics());
		LineMetrics metrics = g0.getFontMetrics().getLineMetrics(string, textures[0].getGraphics());

		g0.setColor(Color.white);
		g1.setColor(Color.white);
		
		g0.drawString(string, (int) ((textures[0].getWidth() - rect.getWidth()) / 2), (int) (metrics.getAscent() + (textures[0].getHeight() - metrics.getHeight()) / 2));
		g1.drawString(string, (int) ((textures[1].getWidth() - rect.getWidth()) / 2), (int) (metrics.getAscent() + (textures[1].getHeight() - metrics.getHeight()) / 2));
		
		return textures;
	}
}

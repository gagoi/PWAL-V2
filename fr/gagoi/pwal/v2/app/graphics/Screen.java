package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

@SuppressWarnings("serial")
public class Screen extends Canvas {

	private BufferedImage img;
	private int[] pixels;

	public Screen(int width, int height) {
		setSize(width, height);
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	}

	public void clear(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	public void render(){
		for (int i = 0; i < pixels.length; i++) {
			
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(50, 50, 50, 500);
	}
}

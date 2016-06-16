package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Iterator;
import java.util.TimerTask;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render_Scaled;

@SuppressWarnings("serial")
public class Screen {

	private BufferedImage img;
	private int[][] pixels;
	private int width, height;

	public Screen(int width, int height, float scale) {
		this.width = width;
		this.height = height;
		img = new BufferedImage((int) (width / scale), (int) (height / scale), BufferedImage.TYPE_INT_RGB);
		pixels = new int[width][height];

	}

	public void clear(int color) {
		for (int x = 0; x < pixels.length; x++) {
			for (int y = 0; y < pixels[x].length; y++) {
				pixels[x][y] = color;
			}
}
	}

	public void render() {
		for (Iterator<Render_Scaled> renders = Application.getScaledRenders().iterator(); renders.hasNext();) {
			Render_Scaled render = renders.next();
			render.render(img.getGraphics());
		}

	}
	
	public void renderMap(int x, int y){
		
	}

	//
	public void paint(Graphics g) {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) { 
			createBufferStrategy(2);
			return; 
		}
	}

	public void convertPixels(int[] pixels2) {
		for (int x = 0; x < pixels.length; x++) {
			for (int y = 0; y < pixels[x].length; y++) {
				pixels2[x+y*width] = pixels[x][y];
			}
		}
		
	}
}

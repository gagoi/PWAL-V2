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
public class Screen extends Canvas {

	private BufferedImage img;
	private int[] pixels;


	public Screen(int width, int height, float scale) {
		setSize(width, height);
		img = new BufferedImage((int) (width / scale), (int) (height / scale), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		

	}

	public void clear(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	public void render() {
		for (Iterator<Render_Scaled> renders = Application.getScaledRenders().iterator(); renders.hasNext();) {
			Render_Scaled render = renders.next();
			render.render(img.getGraphics());
		}
		

		}

	public void paint(Graphics g) {
		g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

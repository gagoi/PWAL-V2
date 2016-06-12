package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Iterator;
import java.util.TimerTask;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render_Scaled;
import fr.gagoi.pwal.v2.app.game_access.Updater;

@SuppressWarnings("serial")
public class Screen extends Canvas {

	private BufferedImage img;
	private int[] pixels;

	private int FPS;
	
	public Screen(int width, int height) {
		setSize(width, height);
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		Application.getUpdater().updateAtFixedRate(new TimerTask() {	
			@Override
			public void run() {
				clear(0);
				render();
				FPS++;
			}
		}, 1000/120, 1000/120, "RENDER", "RenderAll");
		
		Application.getUpdater().updateAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Application.getWindowLogger().log("FPS", FPS + "");
				FPS = 0;
			}
		}, 1000, 1000, "FPS_RESET", "Permet de compter les fps.");
		
	}

	public void clear(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	public void render(){
		for (Iterator<Render_Scaled> renders = Application.getRenders().iterator(); renders.hasNext();) {
			Render_Scaled render = renders.next();
			render.render(getGraphics());
			
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(50, 50, 50, 500);
	}
}

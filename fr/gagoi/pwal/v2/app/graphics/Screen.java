package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render_Scaled;

public class Screen {

	private BufferedImage img;
	private int width, height;

	public Screen(int width, int height, float scale) {
		this.width = (int) (width / scale);
		this.height = (int) (height / scale);
		img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

	}

	public void clear(int color) {
		img.getGraphics().setColor(new Color(color));
		img.getGraphics().fillRect(0, 0, getWidth(), getHeight());
	}

	public void render() {
		for (Iterator<Render_Scaled> renders = Application.getScaledRenders().iterator(); renders.hasNext();) {
			Render_Scaled render = renders.next();
			render.render(img.getGraphics());
		}

	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public BufferedImage getImg(){
		return this.img;
	}
}

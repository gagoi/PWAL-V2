package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.TimerTask;

import javax.swing.JFrame;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private Screen screen;
	private int FPS;
	private BufferedImage bf, oldBf;

	public Window(String title, int width, int height, float scale) {
		this.screen = new Screen(width, height, scale);
		this.bf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.oldBf = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(width, height);

		setVisible(true);

		Application.getUpdater().updateAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				render();
				FPS++;
			}
		}, 1000 / Application.getFps(), 1000 / Application.getFps(), "RENDER", "RenderAll");

		Application.getUpdater().updateAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Application.getWindowLogger().log("FPS", FPS + "");
				FPS = 0;
			}
		}, 1000, 1000, "FPS_RESET", "Permet de compter les fps.");

	}

	public void render() {
		screen.clear(Color.BLACK);
		screen.render();
		bf.getGraphics().drawImage(screen.getImg(), 0, 0, getWidth(), getHeight(), null);
		for (Iterator<Render> renders = Application.getRenders().iterator(); renders.hasNext();) {
			Render render = renders.next();
			render.render(bf.getGraphics(), getWidth(), getHeight());
		}
//		if (!oldBf.equals(bf)) {
			repaint();
//			oldBf = bf;
//		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(bf, 0, 0, null);
	}
}

package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private Screen screen;
	private GameCanvas canvas;
	private int FPS;

	public Window(String title, int width, int height, float scale) {
		this.screen = new Screen(width, height, scale);
		this.canvas = new GameCanvas(screen);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(canvas);
		pack();

		setVisible(true);
		
		Application.getUpdater().updateAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				screen.clear(0);
				screen.render();
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

	@Override
	public void paint(Graphics g) {
		for (Iterator<Render> renders = Application.getRenders().iterator(); renders.hasNext();) {
			Render render = renders.next();
			render.render(g, getWidth(), getHeight());

		}
	}
}

package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JFrame;

import fr.gagoi.pwal.v2.app.core.Application;
import fr.gagoi.pwal.v2.app.game_access.Render;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	private Screen screen;

	public Window(String title, int width, int height, float scale) {
		this.screen = new Screen(width, height, scale);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(screen);
		screen.createBufferStrategy(2);
		pack();
		
		
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println(getWidth());
		super.paint(g);
		for (Iterator<Render> renders = Application.getRenders().iterator(); renders.hasNext();) {
			Render render = renders.next();
			render.render(g, getWidth(), getHeight());
			
		}
	}
}

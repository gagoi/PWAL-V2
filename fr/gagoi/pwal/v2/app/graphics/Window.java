package fr.gagoi.pwal.v2.app.graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	private Screen screen;

	public Window(String title, int width, int height) {
		this.screen = new Screen(width, height);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		add(screen);
		pack();
		
		setVisible(true);
	}
}

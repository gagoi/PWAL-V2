package fr.gagoi.pwal.v2.app.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Screen extends Canvas {

	public Screen(int width, int height) {
		setSize(width, height);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(50, 50, 50, 500);
	}
}
